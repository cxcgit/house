package com.k9501.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.Type;
import com.k9501.house.entity.TypeExample;
import com.k9501.house.mapper.TypeMapper;
import com.k9501.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public Type selectOne(Integer id){
        return typeMapper.selectOne(id);
    };

    @Override
    public int deleteByIds(Integer[] ids) {
        return typeMapper.deleteByIds(ids);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {

        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Type record) {

        return typeMapper.insert(record);
    }

    @Override
    public int insertSelective(Type record) {

        return typeMapper.insertSelective(record);
    }

    @Override
    public List<Type> selectAll() {
        TypeExample typeExample = new TypeExample();
        return typeMapper.selectByExample(typeExample);
    }

    @Override
    public PageInfo<Type> selectByExample(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        TypeExample typeExample = new TypeExample();
        List<Type> typeList = typeMapper.selectByExample(typeExample);
        return new PageInfo<>(typeList);
    }

    @Override
    public Type selectByPrimaryKey(Integer id) {

        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Type record) {

        return typeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Type record) {

        return typeMapper.updateByPrimaryKey(record);
    }
}
