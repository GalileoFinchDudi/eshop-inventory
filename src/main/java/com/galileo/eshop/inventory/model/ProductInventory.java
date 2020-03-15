package com.galileo.eshop.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author galileo
 * @ClassName InventoryCnt
 * @Description 库存数量model
 * @Date 2020/3/15 16:50
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventory {

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 库存数量
     */
    private Long inventoryCnt;

}
