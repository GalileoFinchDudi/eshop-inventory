package com.galileo.eshop.inventory.mapper;

import com.galileo.eshop.inventory.model.User;

/**
 * 测试用户的Mapper接口
 * @author galileo
 * @ClassName UserMapper
 * @Description TODO
 * @Date 2020/3/15 11:55
 * @Version 1.0
 **/
public interface UserMapper {

    /**
     * 查询用户的信息
     * @return
     */
    User findUserInfo();
}
