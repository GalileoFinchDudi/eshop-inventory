package com.galileo.eshop.inventory.dao.impl;

import com.galileo.eshop.inventory.dao.RedisDAO;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;

/**
 * @author galileo
 * @ClassName RedisDAOImpl
 * @Description TODO
 * @Date 2020/3/15 12:36
 * @Version 1.0
 **/
@Repository("redisDAO")
public class RedisDAOImpl implements RedisDAO {

    @Resource
    private JedisCluster jedisCluster;

    @Override
    public void set(String key, String value) {
        jedisCluster.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }
}
