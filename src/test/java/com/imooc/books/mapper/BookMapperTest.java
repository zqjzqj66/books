package com.imooc.books.mapper;

import com.imooc.books.bean.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: BookMapperTest
 * @date 2018/12/25 20:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void listBook(){
        List<Book> all = bookMapper.findAll();
        Assert.assertNotEquals(0,all.size());
    }


    @Test
    public void findOne(){
        Optional<Book> all = bookMapper.findById(1);
        System.out.println(all.get());
        Assert.assertNotEquals(null,all.get());
    }

    @Test
    @Transactional
    public void deleteBook(){
        bookMapper.deleteById(1);
    }

    @Test
    public void insertBook(){
        Book book = new Book();
        book.setBookName("adf");
        book.setBookNumber(10);
        book.setBookPrice(110);
        LocalDate localDate = LocalDate.now();
        book.setBookDate(localDate);
        Book all = bookMapper.save(book);
        Assert.assertNotEquals(null,all);
    }


}