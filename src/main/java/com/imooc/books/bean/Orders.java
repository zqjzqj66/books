package com.imooc.books.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: Orders
 * @date 2018/12/25 20:04
 */
@Entity
@Data
public class Orders{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  ordersId;

    private Integer  number;

    private String bookName;

    private String name;

}
