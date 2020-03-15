package com.galileo.eshop.inventory.service;

import com.galileo.eshop.inventory.model.ProductInventory;

/**
 * @author galileo
 * @ClassName InventoryCntService
 * @Description 商品库存Service接口
 * @Date 2020/3/15 16:55
 * @Version 1.0
 **/
public interface ProductInventoryService {

    /**
     * 更新商品库存
     * @param productInventory 商品库存
     */
    void updateProductInventory(ProductInventory productInventory);

}
