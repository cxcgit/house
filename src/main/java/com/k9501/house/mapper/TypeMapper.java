package com.k9501.house.mapper;

import com.k9501.house.entity.Type;
import com.k9501.house.entity.TypeExample;
import java.util.List;

public interface TypeMapper {
    Type selectOne(Integer id);

    int deleteByIds(Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}