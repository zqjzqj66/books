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
 * @ClassName: Customer
 * @date 2018/12/25 21:19
 */

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  customerId;

    private  String  name;

    private  String  sex;

    private  Integer  age;
}
