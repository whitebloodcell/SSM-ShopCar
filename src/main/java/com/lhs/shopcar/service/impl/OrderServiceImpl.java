package com.lhs.shopcar.service.impl;

import com.lhs.shopcar.domain.dto.CartsDto;
import com.lhs.shopcar.domain.dto.OrderDto;
import com.lhs.shopcar.domain.entity.Carts;
import com.lhs.shopcar.domain.entity.Order;
import com.lhs.shopcar.domain.entity.Product;
import com.lhs.shopcar.exception.ServiceException;
import com.lhs.shopcar.mapper.CartsMapper;
import com.lhs.shopcar.mapper.OrderMapper;
import com.lhs.shopcar.mapper.ProductMapper;
import com.lhs.shopcar.service.OrderService;
import com.lhs.shopcar.utils.ErrorStatus;
import com.lhs.shopcar.utils.GenerateCodeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;
    @Resource
    CartsMapper cartsMapper;
    @Resource
    ProductMapper productMapper;
    /**
     * 1. 生成订单号
     * 2. 减少库存
     * 3. 删除购物车
     * @param orderDto
     * @return
     */
    @Transactional
    @Override
    public int generateOrder(OrderDto orderDto) throws ServiceException{
        //生成订单号
        String orderNo = GenerateCodeUtil.createCodeNum("OR");
        //购物车集合
        List<CartsDto> carts = orderDto.getCarts();
        //总价
        BigDecimal total = new BigDecimal(0);
        //购物车ID集合
        List<Integer> cartsId = new ArrayList<>();
        //遍历购物车集合
        for (CartsDto cart : carts) {
            //商品id
            int pid = cart.getPid();
            //查看商品信息
            Product product = productMapper.selectStockById(pid);
            //得到库存
            int stock = product.getStock();
            //减少库存
            int cartNum = cart.getCount();
            if(stock>=cartNum){
                stock -= cartNum;
                //更新到数据库
                int row = productMapper.updateStockById(pid, stock, product.getVersion());
                if(row==0){
                    throw new ServiceException(ErrorStatus.SERVICE_ERROR);
                }
                //购买数量
                BigDecimal count = new BigDecimal(cart.getCount());
                //商品单价
                BigDecimal price = product.getPromotePrice();
                // 计算总价   价格 * 数量
                BigDecimal multiply = price.multiply(count);
                total.add(multiply);
            }else {
                throw new ServiceException("库存不够",2000);
            }

            //添加购物车ID到集合
            cartsId.add(cart.getCartsId());
        }
        //保存订单
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setMemberId((long) orderDto.getMemberId());
        order.setTotal(total);
        orderMapper.insert(order);
        //删除购物车记录
        cartsMapper.updateStatusByCartsId(cartsId);
        return order.getOrderId();
    }
}
