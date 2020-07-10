package com.lhs.shopcar.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {
    private Integer pid;

    /**
    * 商品的名称
    */
    private String name;

    /**
    * 商品的子标题
    */
    private String subTitle;

    /**
    * 原价
    */
    private BigDecimal orignalPrice;

    /**
    * 现价
    */
    private BigDecimal promotePrice;

    /**
    * 库存
    */
    private Integer stock;

    /**
    * 分类ID
    */
    private Integer cid;

    private Date createDate;

    /**
     * 乐观锁
     * */
    private Integer version;
}