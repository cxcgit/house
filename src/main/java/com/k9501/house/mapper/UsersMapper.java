package com.k9501.house.mapper;

import com.k9501.house.entity.Users;
import com.k9501.house.entity.UsersExample;
import java.util.List;

public interface UsersMapper {
    int deleteByIds(Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}
