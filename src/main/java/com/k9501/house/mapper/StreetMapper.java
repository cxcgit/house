package com.k9501.house.mapper;

import com.k9501.house.entity.Street;
import com.k9501.house.entity.StreetExample;
import java.util.List;

public interface StreetMapper {
    /**
     * 通多区域编号(外键)删除记录
     * @param id 区域编号
     * @return 返回删除条数
     */
    int deleteByDistrictId(Integer id);

    /**
     * 通过区域标号（编号）删除多条记录
     * @param ids 区域编号数组
     * @return 返回删除条数
     */
    int deleteByDistrictIds(Integer[] ids);

    /**
     * 通过街道编号删除多条记录
     * @param ids 街道标号数组
     * @return
     */
    int deleteByIds(Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
}