package com.imooc.books.controoler;

import com.imooc.books.bean.Customer;
import com.imooc.books.bean.Msg;
import com.imooc.books.mapper.CustomerMapper;
import com.imooc.books.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: CustomerController
 * @date 2018/12/25 22:25
 */
@Api("用户列表")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation("获取所有的用户")
    @GetMapping("/listCustomer")
    public Msg listCustomer(){
        List<Customer> customers= customerService.listCustomer();
        return Msg.success().add("list",customers);
    }

    @ApiOperation("修改用户")
    @PostMapping("updateCustomer")
    public Msg updateCustomer(Customer customer){
        customerService.updateCustomer(customer);
        return Msg.success();
    }

    @ApiOperation("添加用户")
    @PostMapping("addCustomer")
    public  Msg addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return Msg.success();
    }

}
