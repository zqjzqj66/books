package com.imooc.books.controoler;

import com.imooc.books.bean.Msg;
import com.imooc.books.bean.Orders;
import com.imooc.books.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: OrdersController
 * @date 2018/12/25 22:21
 */
@Api("订单页面")
@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @ApiOperation("删除订单")
    @GetMapping("/deleteOrder")
    public Msg deleteOrder(@RequestParam(value = "id",required = true) Integer id){
        ordersService.deleteOrder(id);
        return Msg.success();
    }

    @ApiOperation("保存订单")
    @PostMapping("/save")
    public Msg save(Orders orders){
        Orders save = ordersService.save(orders);
        return Msg.success().add("result",save);
    }

    @ApiOperation("获取所有订单")
    @GetMapping("/listOrder")
    public Msg listOrder(){
        List<Orders> orders = ordersService.listOrder();
        return Msg.success().add("list",orders);
    }
}
