package com.lhs.shopcar.service.impl;

import com.lhs.shopcar.domain.entity.Carts;
import com.lhs.shopcar.domain.entity.Product;
import com.lhs.shopcar.mapper.CartsMapper;
import com.lhs.shopcar.service.CartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartsServiceImpl implements CartsService {
    @Resource
    CartsMapper cartsMapper;
    /**
     * @param mid
     * @param product
     * @return 1.通过用户id跟商品的id查询购车表
     * 2 如果该商品已经存在
     * 3 如果该对象不存在则添加该条记录
     */
    @Override
    public int add(int mid, int quantity, Product product) {
        int count = 0;
        //查询
        Carts carts = cartsMapper.selectByMidAndPid(mid, product.getPid());
        if(carts!=null){
            //如果该商品已经存在 更新的操作
            quantity+=carts.getQuantity();
            count = cartsMapper.updata(carts.getCartId(), quantity);
        }else {
            //添加的操作
            carts = new Carts();
            carts.setMemberId((long) mid);
            carts.setQuantity(quantity);
            carts.setPid(product.getPid());
            carts.setProductName(product.getName());
            count = cartsMapper.insert(carts);
        }
        return count;
    }

    @Override
    public List<Carts> list(int mid) {
        return cartsMapper.selectAll(mid);
    }

    /**
     *  删除购物车
     */
    @Override
    public int deleteCarts(List<Integer> cids) {
        int counts = cartsMapper.updateStatusByCartsId(cids);
        return counts;
    }
}
