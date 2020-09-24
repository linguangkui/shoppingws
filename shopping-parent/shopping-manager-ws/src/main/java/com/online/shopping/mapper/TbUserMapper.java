package com.online.shopping.mapper;

import com.online.shopping.pojo.TbUser;

public interface TbUserMapper {
    /**
     * 根据username查询用户信息
     * @param username
     * @return
     */
    TbUser selectUserByUsername(String username);
}
