package com.k9501.house.controller.admin;


import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.Street;
import com.k9501.house.service.StreetService;
import com.k9501.house.util.StreetCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("name=adminStreet")
@RequestMapping("/admin/street")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("selectAllStreet")
    @ResponseBody
    public List<Street> selectAllStreet(){
        return streetService.selectAll();
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(StreetCondition streetCondition){
        PageInfo<Street> pageInfo = streetService.selectByExample(streetCondition);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(Street street){
        int i = streetService.insertSelective(street);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/selectOne")
    @ResponseBody
    public Street insert(Integer id){
        Street street = streetService.selectByPrimaryKey(id);
        return street;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Street street){
        int i = streetService.updateByPrimaryKeySelective(street);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        int i = streetService.deleteByPrimaryKey(id);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/deleteMore")
    @ResponseBody
    public String deleteMore(String id){
        //将id字符串转化为数组
        String[] strings = id.split(",");
        Integer[] ids=new Integer[strings.length];
        for (int i = 0; i <strings.length ; i++) {
            ids[i]=Integer.valueOf(strings[i]);
        }
        int i = streetService.deleteByIds(ids);
        return "{\"result\":"+i+"}";
    }
}
