package com.lhs.shopcar.mapper;

import com.lhs.shopcar.domain.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * 订单表Mapper
 */
public interface OrderMapper {
    /**
     * 插入订单
     * @param order
     * @return
     */
    int insert (@Param("order") Order order);
}