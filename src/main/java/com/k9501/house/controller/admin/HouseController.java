package com.k9501.house.controller.admin;

import com.github.pagehelper.PageInfo;
import com.k9501.house.service.HouseService;
import com.k9501.house.util.HouseCondition;
import com.k9501.house.util.HouseExt;
import com.k9501.house.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller("name=adminHouse")
@RequestMapping("/admin/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("/selectByIspass")
    @ResponseBody
    public Map<String,Object> selectByIspass(HouseCondition houseCondition){
        PageInfo<HouseExt> pageInfo = houseService.selectAll(houseCondition);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("/updateByIspass")
    @ResponseBody
    public String updateByIspass(String id,Integer ispass,String telephone){
        int i = houseService.updateIspassByPrimaryKey(id,ispass);
//        if (i>0&&telephone!=null){
//            String msg="您发布的出租房已通过审核";
//            SmsUtil.sendMsg(telephone,msg);
//        }
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/updateMoreByIspass")
    @ResponseBody
    public String updateMoreByIspass(String id,Integer ispass,String telephone) {
        String[] ids = id.split(",");
        int i = houseService.updateIspassByPrimaryKeys(ids,ispass);
//        if (i>0&&telephone!=null){
//            String msg="您发布的出租房已通过审核";
//            SmsUtil.sendMsg(telephone,msg);
//        }
        return "{\"result\":" + i + "}";
    }
}
