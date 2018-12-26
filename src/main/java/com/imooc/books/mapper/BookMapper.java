package com.imooc.books.mapper;

import com.imooc.books.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: BookMapper
 * @date 2018/12/25 20:43
 */
public interface BookMapper extends JpaRepository<Book,Integer> {
}
