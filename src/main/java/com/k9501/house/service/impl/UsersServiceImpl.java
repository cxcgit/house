package com.k9501.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.k9501.house.entity.Users;
import com.k9501.house.entity.UsersExample;
import com.k9501.house.mapper.UsersMapper;
import com.k9501.house.service.UsersService;
import com.k9501.house.util.MD5Utils;
import com.k9501.house.util.UsersCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int deleteByIds(Integer[] ids) {
        return usersMapper.deleteByIds(ids);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Users record) {
        return usersMapper.insert(record);
    }

    /**
     * 添加用户
     * @param record  参数中的isadmin的值之区分了是用户（0）还是管理员（1）
     * @return
     */
    @Override
    public int insertSelective(Users record) {
        //给密码加密
        record.setPassword(MD5Utils.md5Encrypt(record.getPassword()));
        return usersMapper.insertSelective(record);
    }

    /**
     * 通过名字去数据路查找记录，验证名字是否可用
     * @param users
     * @return 返回0表示可用  1表示不可用
     */
    @Override
    public int selectByName(Users users) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIsadminEqualTo(users.getIsadmin());
        criteria.andNameEqualTo(users.getName());
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        return usersList.size()==0?0:1;
    }

    /**
     * 登陆
     * @param users
     * @return user
     */
    @Override
    public Users login(Users users) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIsadminEqualTo(users.getIsadmin());
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(users.getPassword()));
        criteria.andNameEqualTo(users.getName());
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        return usersList.size()==0?null:usersList.get(0);
    }

    /**
     * 分页加条件查询全部
     * @param usersCondition
     * @return
     */
    @Override
    public PageInfo<Users> selectByExample(UsersCondition usersCondition) {
        PageHelper.startPage(usersCondition.getPage(),usersCondition.getRows());
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIsadminEqualTo(new Integer(1));
        if (usersCondition.getTelePhone()!=null){
            criteria.andTelephoneLike("%"+usersCondition.getTelePhone()+"%");
        }
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        return new PageInfo<>(usersList);
    }

    @Override
    public Users selectByPrimaryKey(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        //修改密码 给密码加密
        record.setPassword(MD5Utils.md5Encrypt(record.getPassword()));
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }
}
