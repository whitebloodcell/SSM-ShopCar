package com.lhs.shopcar.service;

import com.lhs.shopcar.domain.dto.OrderDto;
import com.lhs.shopcar.exception.ServiceException;

/**
 * 订单业务层
 * */
public interface OrderService {
    int generateOrder (OrderDto orderDto) throws ServiceException;
}
