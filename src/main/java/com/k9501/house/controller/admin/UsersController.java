package com.k9501.house.controller.admin;

import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.Users;
import com.k9501.house.service.UsersService;
import com.k9501.house.util.UsersCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller("name=adminUsers")
@RequestMapping("/admin/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public Map<String,Object> selectAll(UsersCondition usersCondition){
        PageInfo<Users> pageInfo = usersService.selectByExample(usersCondition);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(Users users){
        int i = usersService.insertSelective(users);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/selectOne")
    @ResponseBody
    public Users selectOne(Integer id){
        Users users = usersService.selectByPrimaryKey(id);
        return users;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Users users){
        int i = usersService.updateByPrimaryKeySelective(users);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        int i = usersService.deleteByPrimaryKey(id);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/deleteMore")
    @ResponseBody
    public String delete(String id){
        String[] strings = id.split(",");
        Integer[] ids=new Integer[strings.length];
        for (int i = 0; i <strings.length ; i++) {
            ids[i]=Integer.valueOf(strings[i]);
        }
        int i = usersService.deleteByIds(ids);
        return "{\"result\":"+i+"}";
    }
}
