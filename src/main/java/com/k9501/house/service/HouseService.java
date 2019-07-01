package com.k9501.house.service;

import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.House;
import com.k9501.house.util.HouseCondition;
import com.k9501.house.util.HouseExt;


public interface HouseService {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    /**
     * 添加房屋
     * @param record
     * @return
     */
    int insertSelective(House record);

    PageInfo<HouseExt> selectByUsersIdExample(HouseCondition houseCondition);

    PageInfo<HouseExt> selectAll(HouseCondition houseCondition);

    House selectByPrimaryKey(String id);

    HouseExt selectOne(String id);

    int updateIsdelByPrimaryKeySelective(HouseCondition houseCondition);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    int updateIspassByPrimaryKey(String id,Integer ispass);

    int updateIspassByPrimaryKeys(String[] ids,Integer ispass);
}
