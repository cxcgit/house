package com.k9501.house.controller.admin;

import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.Type;
import com.k9501.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller("name=adminType")
@RequestMapping("/admin/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/selectAllType")
    @ResponseBody
    public List<Type> selectAllType(){
        return typeService.selectAll();
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(Integer page,Integer rows){
        PageInfo<Type> pageInfo = typeService.selectByExample(page, rows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(Type type){
        int i = typeService.insertSelective(type);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Type type){
        int i = typeService.updateByPrimaryKeySelective(type);
        return "{\"result\":"+i+"}";
    }

    /**
     * 删除多条记录
     * @param id id字符串
     * @return
     */
    @RequestMapping("/deleteMore")
    @ResponseBody
    public String delete(String id){
        String[] strings = id.split(",");
        Integer[] ids=new Integer[strings.length];
        for (int i = 0; i <strings.length ; i++) {
            ids[i]=Integer.valueOf(strings[i]);
        }
        int i = typeService.deleteByIds(ids);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        int i = typeService.deleteByPrimaryKey(id);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/selectOne")
    @ResponseBody
    public Type selectOne(Integer id){
        Type type=typeService.selectByPrimaryKey(id);
        return type;
    }
}
