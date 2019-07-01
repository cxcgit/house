package com.k9501.house.controller.page;

import com.k9501.house.entity.District;
import com.k9501.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("name=pageDistrict")
@RequestMapping("/page/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<District> selectAll(){
        return districtService.selectAll();
    }
}
