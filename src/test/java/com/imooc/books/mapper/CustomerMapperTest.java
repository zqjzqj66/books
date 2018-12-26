package com.imooc.books.mapper;

import com.imooc.books.bean.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: CustomerMapperTest
 * @date 2018/12/25 21:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerMapperTest {

    @Autowired
    private  CustomerMapper customerMapper;


    @Test
    public void listCustomer(){
        List<Customer> all = customerMapper.findAll();
        Assert.assertNotEquals(0,all.size());
    }

    @Test
    public void updateCustomer(){
        Customer customer = new Customer();
        customer.setCustomerId(2);
        customer.setName("hhhhh");
        customer.setSex("adf");
        Customer save = customerMapper.save(customer);
        Assert.assertNotEquals(null,save);
    }

    @Test
    public void addCustomer(){
        Customer customer = new Customer();
        customer.setAge(10);
        customer.setName("asdfs");
        customer.setSex("adf");
        Customer save = customerMapper.save(customer);
        Assert.assertNotEquals(null,save);
    }


}