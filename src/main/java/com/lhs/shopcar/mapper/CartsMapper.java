package com.lhs.shopcar.mapper;

import com.lhs.shopcar.domain.entity.Carts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartsMapper {
    /**
     * 更新购物车的数量
     *
     * @param cartsId 购物车iD
     * @param num     数量
     * @return
     */
    int updata(@Param("cartsId") int cartsId,@Param("num") int num);

    /**
     * 添加购物车
     * */
    int insert(@Param("carts") Carts carts);

    /**
     * 根据商品id和用户id查询购物车记录
     * */
    Carts selectByMidAndPid (@Param("mid") int mid ,@Param("pid") int pid);

    /**
     * 根据用户id查询所有购物车记录
     * */
    List<Carts> selectAll (@Param("mid") int mid);

    /**
     * 修改购物车删除状态
     * */
    int updateStatusByCartsId(@Param("cids") List<Integer> cids);
}
