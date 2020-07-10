package com.lhs.shopcar.mapper;

import com.lhs.shopcar.domain.entity.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {

    /**
     * 根据id查询商品库存
     * @param pid
     * @return
     */
    Product selectStockById(@Param("pid") int pid);
    /**
     * 根据id修改库存
     * @param pid
     * @param stock
     * @return
     */
    int updateStockById (@Param("pid") int pid,@Param("stock") int stock,@Param("version") int version);
}
