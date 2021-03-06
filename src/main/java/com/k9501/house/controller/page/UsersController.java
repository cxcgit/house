package com.k9501.house.controller.page;


import com.k9501.house.entity.Users;
import com.k9501.house.service.UsersService;
import com.k9501.house.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller("name=pageUsers")
@RequestMapping("/page/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/select")
    @ResponseBody
    public String select(Users users){
        int i = usersService.selectByName(users);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(Users users,String code,HttpSession session){
        String num =session.getAttribute("num").toString();
        int i=0;
        if (num.equals(code)){
            i = usersService.insertSelective(users);
        }
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("/login")
    public String login(Users users, HttpSession session){
        Users user = usersService.login(users);
        if (user!=null){
            session.removeAttribute("msg");

            if (user.getIsadmin()==0){
                //普通用户登录信息
                session.setAttribute("user",user);
                //重定向到查询所有的房子信息
                return "redirect:/page/house/selectAll?ispass=1&isdel=0";
            }
            //管理员登录信息
            session.setAttribute("admin",user);
            return "redirect:/admin/admin.jsp";
        }
        session.setAttribute("msg","登陆失败");
        return "redirect:/page/login.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Users users){
        int i = usersService.updateByPrimaryKeySelective(users);
        return "{\"result\":"+i+"}";
    }

    //注册时发送验证码
    @RequestMapping("/sendMsg")
    @ResponseBody
    public String sendMsg(String tel,HttpSession session){
        int num=(int)(Math.random()*10000);
        System.out.println(num);
        session.setAttribute("num",num);
        String smsText="验证码为"+num+"，60秒内有效";
        int i = SmsUtil.sendMsg(tel, smsText);
        return "{\"result\":"+i+"}";
    }
}

