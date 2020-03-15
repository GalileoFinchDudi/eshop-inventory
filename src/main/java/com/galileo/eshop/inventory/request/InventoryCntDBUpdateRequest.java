package com.galileo.eshop.inventory.request;

import com.galileo.eshop.inventory.model.ProductInventory;

/**
 * @author galileo
 * @ClassName InventoryCntDBUpdateRequest
 * @Description 比如一个商品发生了交以，那么就要修改这个商品对应的库存
 * 此时就会发送请求过来，要求修改库存，那么这个可能就是所谓的data update request，数据更新请求
 * cache aside pattern
 * @Date 2020/3/15 16:44
 * @Version 1.0
 **/
public class InventoryCntDBUpdateRequest implements  Request {

    /**
     * 商品库存
     */
    private ProductInventory productInventory;

    public InventoryCntDBUpdateRequest(ProductInventory productInventory) {
        this.productInventory = productInventory;
    }

    @Override
    public void process() {
        // 删除redis中的缓存

        // 修改数据库中的库存
    }
}
