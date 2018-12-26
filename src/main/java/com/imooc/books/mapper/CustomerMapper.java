package com.imooc.books.mapper;

import com.imooc.books.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: CustomerMapper
 * @date 2018/12/25 21:22
 */
public interface CustomerMapper extends JpaRepository<Customer,Integer> {
}
