package com.lhs.shopcar.service;


import com.lhs.shopcar.domain.entity.Carts;
import com.lhs.shopcar.domain.entity.Product;

import java.util.List;

public interface CartsService {
    int add (int mid, int quantity, Product product);

    List<Carts> list(int mid);

    int deleteCarts (List<Integer> cids);
}
