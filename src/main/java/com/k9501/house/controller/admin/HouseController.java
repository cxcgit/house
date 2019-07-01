package com.k9501.house.controller.admin;

import com.github.pagehelper.PageInfo;
import com.k9501.house.service.HouseService;
import com.k9501.house.util.HouseCondition;
import com.k9501.house.util.HouseExt;
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
    public Map<String,Object> selectByIspass(String priceScope,String floorageScope,HouseCondition houseCondition){
        //将价格区间字符串和面积区间字符串分割开
        if (priceScope!=null&&priceScope!=""){
            String[] prices = priceScope.split("-");
            houseCondition.setPriceFrom(Long.valueOf(prices[0]));
            houseCondition.setPriceTo(Long.valueOf(prices[1]));
        }
        if (floorageScope!=null&&floorageScope!=""){
            String[] floorages = floorageScope.split("-");
            houseCondition.setFloorageFrom(Integer.valueOf(floorages[0]));
            houseCondition.setFloorageTo(Integer.valueOf(floorages[1]));
        }
        PageInfo<HouseExt> pageInfo = houseService.selectAll(houseCondition);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("/updateByIspass")
    @ResponseBody
    public String updateByIspass(String id,Integer ispass){
        int i = houseService.updateIspassByPrimaryKey(id,ispass);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/updateMoreByIspass")
    @ResponseBody
    public String updateMoreByIspass(String id,Integer ispass) {
        String[] ids = id.split(",");
        int i = houseService.updateIspassByPrimaryKeys(ids,ispass);
        return "{\"result\":" + i + "}";
    }
}
