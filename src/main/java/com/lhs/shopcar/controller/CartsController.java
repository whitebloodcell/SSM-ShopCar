package com.lhs.shopcar.controller;

import com.lhs.shopcar.domain.dto.AddCartsDto;
import com.lhs.shopcar.domain.entity.Carts;
import com.lhs.shopcar.service.CartsService;
import com.lhs.shopcar.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartsController {
    @Resource
    CartsService cartsService;

    /**
     * 添加购物车
     * */
    @PostMapping("/add")
    public ResponseEntity<Integer> addCarts(@RequestBody AddCartsDto addCartsDto){
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        int count = cartsService.add(addCartsDto.getMid(), addCartsDto.getQuantity(), addCartsDto.getProduct());
        if(count>0){
            responseEntity = responseEntity.success(count);
        }else {
            responseEntity = responseEntity.error();
        }
        return responseEntity;
    }

    /**
     * 查询购物车
     * */
    @GetMapping("/list/{mid}")
    public ResponseEntity<List<Carts>> list(@PathVariable() int mid){
        List<Carts> list = cartsService.list(mid);
        ResponseEntity<List<Carts>> responseEntity = new ResponseEntity<>();
        responseEntity.setData(list);
        return responseEntity;
    }

    /**
     * 删除购物车记录
     * */
    @DeleteMapping("/delete")
    public ResponseEntity<Integer> deleteCarts (@RequestParam List<Integer> cids){
        ResponseEntity<Integer> responseEntity = null;
        try{
            int counts = cartsService.deleteCarts(cids);
            if(counts>0){
                responseEntity = responseEntity.success(counts);
            }else {
                responseEntity = responseEntity.error();
            }
        }catch (Exception e){
            responseEntity = responseEntity.error();
        }
        return responseEntity;
    }
}
