package com.k9501.house.controller.page;


import com.k9501.house.entity.Type;
import com.k9501.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller("name=pageType")
@RequestMapping("/page/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("selectAll")
    @ResponseBody
    public List<Type> selectAll(){
        return typeService.selectAll();
    }
}
