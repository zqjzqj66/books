package com.imooc.books.service;

import com.imooc.books.bean.Orders;
import com.imooc.books.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: OrderService
 * @date 2018/12/25 22:07
 */
@Service
public class OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    public void deleteOrder(Integer id){
        ordersMapper.deleteById(id);
    }


    public Orders save(Orders orders){
        return ordersMapper.save(orders);
    }

    public List<Orders> listOrder(){
        return  ordersMapper.findAll();
    }
}
