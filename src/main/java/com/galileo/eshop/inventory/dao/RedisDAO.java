package com.galileo.eshop.inventory.dao;

/**
 * @author galileo
 * @ClassName RedisDao
 * @Description TODO
 * @Date 2020/3/15 12:34
 * @Version 1.0
 **/
public interface RedisDAO {

    void set(String key, String value);

    String get(String key);

    void delete(String key);
}
