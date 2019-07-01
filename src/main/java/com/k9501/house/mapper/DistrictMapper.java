package com.k9501.house.mapper;

import com.k9501.house.entity.District;
import com.k9501.house.entity.DistrictExample;
import java.util.List;

public interface DistrictMapper {
    int deleteByIds(Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}