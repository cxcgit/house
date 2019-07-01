package com.k9501.house.service;

import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.District;

import java.util.List;


public interface DistrictService {
    int deleteByIds(Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectAll();

    PageInfo<District> selectByExample(Integer page,Integer rows);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}
