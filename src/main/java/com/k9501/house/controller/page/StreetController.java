package com.k9501.house.controller.page;

import com.k9501.house.entity.Street;
import com.k9501.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("name=pageStreet")
@RequestMapping("/page/street")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("/selectByDistrictId")
    @ResponseBody
    public List<Street> selectByDistrictId(Integer id){
        return streetService.selectByDistrictId(id);
    }
}
