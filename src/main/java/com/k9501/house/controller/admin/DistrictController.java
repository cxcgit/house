package com.k9501.house.controller.admin;


import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.District;
import com.k9501.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller("name=adminDistrict")
@RequestMapping("/admin/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(Integer page,Integer rows){
        PageInfo<District> pageInfo = districtService.selectByExample(page, rows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(District district){
        int i = districtService.insertSelective(district);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(District district){
        int i = districtService.updateByPrimaryKeySelective(district);
        return "{\"result\":"+i+"}";
    }

    /**
     * 删除多条记录
     * @param id id字符串
     * @return
     */
    @RequestMapping("/deleteMore")
    @ResponseBody
    public String deleteMore(String id){
        //将id字符串转化为数组
        String[] strings = id.split(",");
        Integer[] ids=new Integer[strings.length];
        for (int i = 0; i <strings.length ; i++) {
            ids[i]=Integer.valueOf(strings[i]);
        }
        int i = districtService.deleteByIds(ids);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        int i = districtService.deleteByPrimaryKey(id);
        return "{\"result\":"+i+"}";
    }



    @RequestMapping("/selectOne")
    @ResponseBody
    public District selectOne(Integer id){
        District district = districtService.selectByPrimaryKey(id);
        return district;
    }
}
