package com.imooc.books.controoler;

import com.imooc.books.bean.Book;
import com.imooc.books.bean.Msg;
import com.imooc.books.mapper.BookMapper;
import com.imooc.books.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: BookController
 * @date 2018/12/25 22:17
 */
@Api("图书页面")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;


    @ApiOperation("获取所有图书")
    @GetMapping("/listBook")
    public Msg listBook(){
        List<Book> books = bookService.listBook();
        return Msg.success().add("books",books);
    }

    @ApiOperation("根据Id查找图书")
    @GetMapping("/findOne")
    public Msg findOne(@RequestParam(value = "id",required = true) Integer id){
        Book book = bookService.findBook(id);
        return Msg.success().add("book",book);
    }

    @ApiOperation("根据id删除图书")
    @GetMapping("/deleteBook")
    public Msg deleteBook(@RequestParam(value = "id",required = true) Integer id){
        bookService.deleteBook(id);
        return Msg.success();
    }

    @ApiOperation("保存图书")
    @PostMapping("/insertBook")
    public Msg insertBook(Book book){
        bookService.insertBook(book);
        return Msg.success();
    }

}
