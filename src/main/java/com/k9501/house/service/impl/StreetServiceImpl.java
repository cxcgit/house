package com.k9501.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.Street;
import com.k9501.house.entity.StreetExample;
import com.k9501.house.mapper.StreetMapper;
import com.k9501.house.service.StreetService;
import com.k9501.house.util.StreetCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public int deleteByIds(Integer[] ids) {
        return streetMapper.deleteByIds(ids);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return streetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Street record) {
        return streetMapper.insert(record);
    }

    @Override
    public int insertSelective(Street record) {
        return streetMapper.insertSelective(record);
    }

    /**
     * 通过区域编号查询所有街道
     * @param id
     * @return
     */
    @Override
    public List<Street> selectByDistrictId(Integer id) {
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        return streetMapper.selectByExample(streetExample);
    }

    /**
     * 查询所有街道
     * @return
     */
    @Override
    public List<Street> selectAll() {
        return streetMapper.selectByExample(new StreetExample());
    }

    /**
     * 通过区域编号查询所有街道并分页
     * @param streetCondition
     * @return
     */
    @Override
    public PageInfo<Street> selectByExample(StreetCondition streetCondition) {
        PageHelper.startPage(streetCondition.getPage(),streetCondition.getRows());
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(streetCondition.getDistrictId());
        List<Street> streetList = streetMapper.selectByExample(streetExample);
        return new PageInfo<>(streetList);
    }

    @Override
    public Street selectByPrimaryKey(Integer id) {
        return streetMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Street record) {
        return streetMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Street record) {
        return streetMapper.updateByPrimaryKey(record);
    }
}
