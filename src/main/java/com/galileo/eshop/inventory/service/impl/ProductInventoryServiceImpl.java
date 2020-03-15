package com.galileo.eshop.inventory.service.impl;

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

    @Override
    public void updateProductInventory(ProductInventory productInventory) {

        productInventoryMapper.updateProductInventory(productInventory);

    }
}
