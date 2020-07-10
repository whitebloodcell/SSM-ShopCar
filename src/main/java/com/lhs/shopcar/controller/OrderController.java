package com.lhs.shopcar.controller;

import com.lhs.shopcar.domain.dto.OrderDto;
import com.lhs.shopcar.exception.ServiceException;
import com.lhs.shopcar.service.OrderService;
import com.lhs.shopcar.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;
    /**
     * 事务的知识点  锁
     * 生成订单  如何生成订单号 (要求在你的系统中必须是唯一)
     * 计算总价
     * 判断库存
     * 减少库存  id    stock
     * 通过商品ID成库存
     * 10 -2
     * update   8
     * 发起支付
     */
    @PostMapping("/generate")
    public ResponseEntity<Integer> generateOrder(@RequestBody OrderDto orderDto){
        ResponseEntity<Integer> responseEntity = null;
        int orderId = 0;
        try {
            orderId = orderService.generateOrder(orderDto);
            if(orderId!=0){
                responseEntity = responseEntity.success(orderId);
            }else {
                responseEntity = responseEntity.error();
            }
        } catch (ServiceException e) {
            responseEntity = responseEntity.error();
        }
        return responseEntity;
    }
}
