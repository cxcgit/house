package com.k9501.house.service;

import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.Type;
import com.k9501.house.entity.TypeExample;

import java.util.List;

public interface TypeService {
    int deleteByIds(Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectAll();

    PageInfo<Type> selectByExample(Integer page,Integer rows);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}
