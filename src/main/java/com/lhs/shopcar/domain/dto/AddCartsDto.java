package com.lhs.shopcar.domain.dto;

import com.lhs.shopcar.domain.entity.Product;
import lombok.Data;

@Data
public class AddCartsDto {
    private Integer mid;
    private Integer quantity;
    private Product product;
}
