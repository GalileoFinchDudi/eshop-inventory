package com.galileo.eshop.inventory.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.galileo.eshop.inventory.dao.RedisDAO;
import com.galileo.eshop.inventory.mapper.UserMapper;
import com.galileo.eshop.inventory.model.User;
import com.galileo.eshop.inventory.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 * @author galileo
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 2020/3/15 11:57
 * @Version 1.0
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisDAO redisDAO;

    @Override
    public User findUserInfo() {
        return userMapper.findUserInfo();
    }

    @Override
    public User getCachedUserInfo() {
        redisDAO.set("cached_user_lisi", "{\"name\": \"李四\", \"age\": 28}");

        String userJson = redisDAO.get("cached_user_lisi");
        JSONObject userJSONObject = JSONObject.parseObject(userJson);

        User user = new User();
        user.setName(userJSONObject.getString("name"));
        user.setAge(userJSONObject.getInteger("age"));

        return user;
    }
}
