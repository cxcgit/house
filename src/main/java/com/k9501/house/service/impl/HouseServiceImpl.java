package com.k9501.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.House;
import com.k9501.house.entity.HouseExample;
import com.k9501.house.mapper.HouseMapper;
import com.k9501.house.service.HouseService;
import com.k9501.house.util.HouseCondition;
import com.k9501.house.util.HouseExt;
import com.k9501.house.util.PageCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return houseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(House record) {
        return houseMapper.insert(record);
    }

    @Override
    public int insertSelective(House record) {
        return houseMapper.insertSelective(record);
    }

    /**
     * 查询用户的所有出租房信息，带分页
     * @param houseCondition
     * @return
     */
    @Override
    public PageInfo<HouseExt> selectByUsersIdExample(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getRows());
        List<HouseExt> houseList = houseMapper.selectByUserIdExample(houseCondition);
        return new PageInfo<>(houseList);
    }

    /**
     * 查询全部房屋信息
     * @param houseCondition 分页条件加条件查询
     * @return
     */
    @Override
    public PageInfo<HouseExt> selectAll(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getRows());
        List<HouseExt> houseList = houseMapper.selectAll(houseCondition);
        return new PageInfo<>(houseList);
    }

    @Override
    public House selectByPrimaryKey(String id) {
        return houseMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过id查询一条房屋信息
     * @param id
     * @return
     */
    @Override
    public HouseExt selectOne(String id) {
        return houseMapper.selectOne(id);
    }

    /**
     * 删除单挑，既是将isdel值改为1
     * @param houseCondition
     * @return
     */
    @Override
    public int updateIsdelByPrimaryKeySelective(HouseCondition houseCondition) {
        House house = new House();
        house.setId(houseCondition.getId());
        house.setIsdel(houseCondition.getIsdel());
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    /**
     * 修改房屋信息
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(House record) {
        return houseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(House record) {
        return houseMapper.updateByPrimaryKey(record);
    }

    /**
     * 审核租房信息（单个）
     * @param id
     * @return
     */
    @Override
    public int updateIspassByPrimaryKey(String id,Integer ispass) {
        House house=new House();
        house.setId(id);
        house.setIspass(ispass);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    /**
     * 审核通过租房信息（多个）
     * @param ids
     * @return
     */
    @Override
    public int updateIspassByPrimaryKeys(String[] ids,Integer ispass) {
        //将参数封装到map中
        Map<String,Object> map=new HashMap<>();
        map.put("ispass",ispass);
        map.put("array",ids);
        return houseMapper.updateByPrimaryKeys(map);
    }
}
