package com.k9501.house.controller.page;

import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.*;
import com.k9501.house.service.DistrictService;
import com.k9501.house.service.HouseService;
import com.k9501.house.service.StreetService;
import com.k9501.house.service.TypeService;
import com.k9501.house.util.HouseCondition;
import com.k9501.house.util.HouseExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller("name=pageHouse")
@RequestMapping("/page/house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private StreetService streetService;
    @Autowired
    private DistrictService districtService;


    @RequestMapping("/toFaBu")
    public String toFaBu(Model model){
        List<Type> typeList = typeService.selectAll();
        List<District> districtList = districtService.selectAll();
        model.addAttribute("typeList",typeList);
        model.addAttribute("districtList",districtList);
        return "fabu";
    }

    @RequestMapping("/selectAll")
    public String selectAll(HouseCondition houseCondition, Model model){
        if (houseCondition.getPage()==null){
            houseCondition.setPage(1);
        }
        if (houseCondition.getRows()==null){
            houseCondition.setRows(4);
        }
        List<Type> typeList = typeService.selectAll();
        List<Street> streetList = streetService.selectAll();
        PageInfo<HouseExt> pageInfo = houseService.selectAll(houseCondition);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("typeList",typeList);
        model.addAttribute("streetList",streetList);
        model.addAttribute("houseCondition",houseCondition);
        return "list";
    }

    @RequestMapping("/insert")
    public String insert(House house,@RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile){
        //将文件存储到本地
        //取文件名
        String fname=pfile.getOriginalFilename();
        //取文件后缀
        String sufname=fname.substring(fname.lastIndexOf("."));
        String uuid= UUID.randomUUID().toString();
        //根据时间创建多级文件夹
        String afterPath=new SimpleDateFormat("yyyy\\MM\\dd\\HH\\mm\\ss\\").format(new Date());
        String finalPath="E:\\img\\"+afterPath;
        File file=new File(finalPath);
        if (!file.exists()){
            file.mkdirs();
        }
        try {
            //上传文件到指定位置
            pfile.transferTo(new File(finalPath+uuid+sufname));
        } catch (IOException e) {
            return "error";
        }
        //设置房屋编号
        house.setId(System.currentTimeMillis()+"");
        //设置图片路径
        house.setPath(afterPath+uuid+sufname);
        int i = houseService.insertSelective(house);
        if (i==1){
            return "redirect:/page/house/selectByUsersId";
        }else{
            file.delete();
            return "redirect:/page/house/selectByUsersId";
        }
    }

        @RequestMapping("/selectByUsersId")
        public String selectByUsersId(HouseCondition houseCondition, Model model, HttpSession session){
            if (houseCondition.getPage()==null){
                houseCondition.setPage(1);
            }
            if (houseCondition.getRows()==null){
                houseCondition.setRows(4);
            }
            Users users =(Users) session.getAttribute("user");
            houseCondition.setUserId(users.getId());
            PageInfo<HouseExt> pageInfo = houseService.selectByUsersIdExample(houseCondition);
            model.addAttribute("pageInfo",pageInfo);
            //根据是否删除的状态跳到相应的页面
            if (houseCondition.getIsdel()==0){
                return "guanli";
            }
            return "del";
        }

    @RequestMapping("/selectOne")
    public String selectOne(String id, Model model){
        List<Type> typeList = typeService.selectAll();
        List<Street> streetList = streetService.selectAll();
        HouseExt houseExt = houseService.selectOne(id);
        model.addAttribute("houseExt",houseExt);
        model.addAttribute("typeList",typeList);
        model.addAttribute("streetList",streetList);
        return "details";
    }

    @RequestMapping("/deleteOne")

    public String deleteOne(HouseCondition houseCondition){
        //del起重定向到对应的页面（在管理页面就重定向到管理页面）
        Integer del=null;
        if (houseCondition.getIsdel()==1){
            del=0;
        }else{
            del=1;
        }
        houseService.updateIsdelByPrimaryKeySelective(houseCondition);
        return "redirect:/page/house/selectByUsersId?isdel="+del;
    }

    @RequestMapping("/toChange")
    public String toChange(String id, Model model){
        HouseExt houseExt = houseService.selectOne(id);
        List<Type> typeList = typeService.selectAll();
        List<District> districtList = districtService.selectAll();
        List<Street> streetList = streetService.selectAll();
        model.addAttribute("houseExt",houseExt);
        model.addAttribute("typeList",typeList);
        model.addAttribute("districtList",districtList);
        model.addAttribute("streetList",streetList);
        return "change";
    }

    @RequestMapping("/update")
    public String update(String oldPath,House house,@RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile){
        File file=null;
        //判断用户是否更改图片
        if (pfile.getOriginalFilename()!=""){
            //将文件存储到本地
            //取文件名
            String fname=pfile.getOriginalFilename();
            //取文件后缀
            String sufname=fname.substring(fname.lastIndexOf("."));
            String uuid= UUID.randomUUID().toString();
            //根据时间创建多级文件夹
            String afterPath=new SimpleDateFormat("yyyy\\MM\\dd\\HH\\mm\\ss\\").format(new Date());
            String finalPath="E:\\img\\"+afterPath;
            file=new File(finalPath);
            if (!file.exists()){
                file.mkdirs();
            }
            try {
                //上传文件到指定位置
                pfile.transferTo(new File(finalPath+uuid+sufname));
            } catch (IOException e) {
                return "error";
            }
            //删除旧的照片
            new File("E:\\img\\"+oldPath).delete();
            house.setPath(afterPath+uuid+sufname);
        }
        house.setIspass(0);
        int i = houseService.updateByPrimaryKeySelective(house);
        if (i==1){
            return "redirect:/page/house/selectByUsersId?isdel=0";
        }else{
            if (file!=null){
                file.delete();
            }
            return "redirect:/page/house/selectByUsersId?isdel=0";
        }
    }
}
