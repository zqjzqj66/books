package com.imooc.books.service;

import com.imooc.books.bean.Customer;
import com.imooc.books.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: CustomerService
 * @date 2018/12/25 22:11
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    public List<Customer> listCustomer(){
        return customerMapper.findAll();
    }

    public void updateCustomer(Customer customer){
        customerMapper.save(customer);
    }

    public  void addCustomer(Customer customer){
        customerMapper.save(customer);
    }
}
