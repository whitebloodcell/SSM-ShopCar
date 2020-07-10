package com.lhs.shopcar.domain.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    /**
    * 主键
    */
    private Integer orderItemId;

    /**
    * 订单号
    */
    private Integer orderId;

    /**
    * 会员Id
    */
    private Long memberId;

    /**
    * 商品图片
    */
    private String productPic;

    /**
    * 商品的名称
    */
    private String productName;

    /**
    * 商品的名称
    */
    private BigDecimal productPrice;

    /**
    * 购买的数量
    */
    private Integer productQuantity;

    /**
    * 状态
    */
    private Integer status;

    /**
     * 乐观锁
     * */
    private Integer version;
}