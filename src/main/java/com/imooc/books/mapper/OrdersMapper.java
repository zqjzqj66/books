package com.imooc.books.mapper;

import com.imooc.books.bean.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: Order
 * @date 2018/12/25 21:04
 */
public interface OrdersMapper extends JpaRepository<Orders,Integer> {
}
