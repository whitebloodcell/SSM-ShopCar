package com.lhs.shopcar.domain.dto;

import lombok.Data;

@Data
public class CartsDto {
    //购物车ID
    private int cartsId;
    // 商品ID
    private int pid;
    //商品数量
    private int count;
    // 收货地址
}