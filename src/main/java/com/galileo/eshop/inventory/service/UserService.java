package com.galileo.eshop.inventory.service;

import com.galileo.eshop.inventory.model.User;

/**
 * 用户Service接口
 * @author galileo
 * @ClassName UserService
 * @Description TODO
 * @Date 2020/3/15 11:56
 * @Version 1.0
 **/
public interface UserService {

    /**
     * 查询用户信息
     * @return
     */
    User findUserInfo();

    /**
     * 获取redis缓存中的用户信息
     * @return
     */
    User getCachedUserInfo();
}
