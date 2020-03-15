package com.galileo.eshop.inventory.service.impl;

import com.galileo.eshop.inventory.dao.RedisDAO;
import com.galileo.eshop.inventory.mapper.ProductInventoryMapper;
import com.galileo.eshop.inventory.model.ProductInventory;
import com.galileo.eshop.inventory.service.ProductInventoryService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author galileo
 * @ClassName ProductInventoryServiceImpl
 * @Description 商品库存Service实现类
 * @Date 2020/3/15 17:00
 * @Version 1.0
 **/
@Service("productInventoryService")
public class ProductInventoryServiceImpl implements ProductInventoryService {

    @Resource
    private ProductInventoryMapper productInventoryMapper;

    @Resource
    private RedisDAO redisDAO;

    @Override
    public void updateProductInventory(ProductInventory productInventory) {

        productInventoryMapper.updateProductInventory(productInventory);

    }

    @Override
    public void removeProductInventoryCache(ProductInventory productInventory) {
        String key = "product:inventory:" + productInventory.getProductId();
        redisDAO.delete(key);
    }

    @Override
    public ProductInventory findProductInventory(Integer productId) {
        return productInventoryMapper.findProductInventory(productId);
    }

    @Override
    public void setProductInventoryCache(ProductInventory productInventory) {
        String key = "product:inventory:" + productInventory.getProductId();
        redisDAO.set(key, String.valueOf(productInventory.getInventoryCnt()));
    }
}
