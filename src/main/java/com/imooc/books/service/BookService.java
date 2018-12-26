package com.imooc.books.service;

import com.imooc.books.bean.Book;
import com.imooc.books.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: BookService
 * @date 2018/12/25 22:14
 */
@Service
@RequestMapping("/book")
public class BookService {
    @Autowired
    private BookMapper bookMapper;


    @GetMapping()
    public List<Book> listBook(){
        return bookMapper.findAll();
    }

    @GetMapping("/findBook")
    public Book findBook(@RequestParam(value = "id",required = true)Integer id){
        Optional<Book> all = bookMapper.findById(id);
        return all.get();
    }

    @GetMapping("/deleteBook")
    public void deleteBook(@RequestParam(value = "id",required = true) Integer id){
        bookMapper.deleteById(id);
    }

    @PostMapping("/insertBook")
    public void insertBook(@RequestParam(value = "book",required = true) Book book){
        bookMapper.save(book);
    }
}
