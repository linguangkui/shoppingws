package com.online.shopping.service.impl;

import com.online.shopping.mapper.TbUserMapper;
import com.online.shopping.pojo.TbUser;
import com.online.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;
    @Override
    public TbUser selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
