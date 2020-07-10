package com.lhs.shopcar.domain.dto;

import com.lhs.shopcar.domain.entity.Carts;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    //用户ID
    private int memberId;
    //购物车列表
    private List<CartsDto> carts;
    //收货地址
    private String address;
}
