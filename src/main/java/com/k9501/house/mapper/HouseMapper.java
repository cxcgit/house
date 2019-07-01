package com.k9501.house.mapper;

import com.k9501.house.entity.House;
import com.k9501.house.entity.HouseExample;
import com.k9501.house.util.HouseCondition;
import com.k9501.house.util.HouseExt;


import java.util.List;
import java.util.Map;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    List<HouseExt> selectByUserIdExample(HouseCondition houseCondition);

    List<HouseExt> selectAll(HouseCondition houseCondition);

    House selectByPrimaryKey(String id);

    HouseExt selectOne(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    int updateByPrimaryKeys(Map<String,Object> map);
}