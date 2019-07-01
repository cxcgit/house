package com.k9501.house.service;

import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.Street;
import com.k9501.house.util.StreetCondition;

import java.util.List;


public interface StreetService {
    int deleteByIds(Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByDistrictId(Integer id);

    List<Street> selectAll();

    PageInfo<Street> selectByExample(StreetCondition streetCondition);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
}
