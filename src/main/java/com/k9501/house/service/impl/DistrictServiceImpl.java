package com.k9501.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.District;
import com.k9501.house.entity.DistrictExample;
import com.k9501.house.entity.Street;
import com.k9501.house.mapper.DistrictMapper;
import com.k9501.house.mapper.StreetMapper;
import com.k9501.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    /**
     * 业务处理删除区域之前先删除街道 删除多条记录
     * @param ids ID数组
     * @return 事务成功返回删除条数 失败返回0
     */
    @Override
    @Transactional
    public int deleteByIds(Integer[] ids) {
        try {
            //删除街道
            streetMapper.deleteByDistrictIds(ids);
            //删除区域
            int i=districtMapper.deleteByIds(ids);
            return i;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 业务处理删除区域之前先删除街道
     * @param id 区域编号
     * @return 事务处理成功返回1 失败返回0
     */
    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer id) {
        try {
            //删除街道
            streetMapper.deleteByDistrictId(id);
            //删除区域
            districtMapper.deleteByPrimaryKey(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int insert(District record) {
        return districtMapper.insert(record);
    }

    @Override
    public int insertSelective(District record) {
        return districtMapper.insertSelective(record);
    }

    /**
     * 查询所有区域信息
     * @return
     */
    @Override
    public List<District> selectAll() {
        DistrictExample districtExample = new DistrictExample();
        return districtMapper.selectByExample(districtExample);
    }

    /**
     * 分页查询全部
     * @param page 当前页码
     * @param rows 每页显示条数
     * @return 返回pageInFo对象
     */
    @Override
    public PageInfo<District> selectByExample(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        DistrictExample districtExample = new DistrictExample();
        //设置条件查询参数
        //DistrictExample.Criteria criteria = districtExample.createCriteria();
        //criteria.and....
        List<District> districtList = districtMapper.selectByExample(districtExample);
        return new PageInfo<>(districtList);
    }

    @Override
    public District selectByPrimaryKey(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(District record) {
        return districtMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(District record) {
        return districtMapper.updateByPrimaryKey(record);
    }
}
