package com.galileo.eshop.inventory.mapper;

import com.galileo.eshop.inventory.model.ProductInventory;

/**
 * @author galileo
 * @ClassName InventoryCntMapper
 * @Description 库存数量Mapper
 * @Date 2020/3/15 16:49
 * @Version 1.0
 **/
public interface ProductInventoryMapper {

    /**
     * 更新库存数量
     * @param inventoryCnt 商品库存
     */
    void updateProductInventory(ProductInventory inventoryCnt);
}
