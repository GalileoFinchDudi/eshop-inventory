package com.galileo.eshop.inventory.mapper;

import com.galileo.eshop.inventory.model.ProductInventory;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据商品id查询商品库存信息
     * @param productId 商品id
     * @return
     */
    ProductInventory findProductInventory(@Param("productId") Integer productId);
}
