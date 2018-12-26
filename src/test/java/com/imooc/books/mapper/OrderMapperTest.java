package com.imooc.books.mapper;

import com.imooc.books.bean.Orders;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Description:
 *
 * @author 周启江
 * @ClassName: OrderTest
 * @date 2018/12/25 21:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    private OrdersMapper ordersMapper;


    @Test
    @Transactional
    public void deleteOrder(){
        ordersMapper.deleteById(2);
    }

    @Test
    public void save(){
        Orders order = new Orders();
        order.setBookName("asdfasd");
        order.setName("adfsd");
        order.setNumber(12);
        Orders save = ordersMapper.save(order);
        Assert.assertNotEquals(null,save);
    }

    @Test
    public void listOrder(){
        List<Orders> all = ordersMapper.findAll();
        Assert.assertNotEquals(0,all.size());
    }

}