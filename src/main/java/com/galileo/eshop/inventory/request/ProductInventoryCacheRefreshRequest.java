package com.galileo.eshop.inventory.request;

import com.galileo.eshop.inventory.model.ProductInventory;
import com.galileo.eshop.inventory.service.ProductInventoryService;
import lombok.Data;

/**
 * @author galileo
 * @ClassName ProductInventoryCacheReloadRequest
 * @Description 重新加载商品库存的缓存
 * @Date 2020/3/15 18:00
 * @Version 1.0
 **/
@Data
public class ProductInventoryCacheRefreshRequest implements Request{

    /**
     * 商品库存
     */
    private Integer productId;

    /**
     * 商品库存Service
     */
    private ProductInventoryService productInventoryService;


    @Override
    public void process() {
        // 从数据库中查询最新的商品库存数量
        ProductInventory productInventory = productInventoryService.findProductInventory(productId);
        // 将最新的商品库存数量，刷新到redis缓存中去
        productInventoryService.setProductInventoryCache(productInventory);
    }
}
