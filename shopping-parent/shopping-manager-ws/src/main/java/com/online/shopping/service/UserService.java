package com.online.shopping.service;

import com.online.shopping.pojo.TbUser;

public interface UserService {
    /**
     * 根据username查询用户信息
     * @param username
     * @return
     */
    TbUser selectUserByUsername(String username);
}
