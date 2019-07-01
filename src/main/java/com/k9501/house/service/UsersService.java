package com.k9501.house.service;

import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.Users;
import com.k9501.house.util.UsersCondition;



public interface UsersService {
    int deleteByIds(Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    int selectByName(Users users);

    Users login(Users users);

    PageInfo<Users> selectByExample(UsersCondition usersCondition);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}
