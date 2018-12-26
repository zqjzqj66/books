package com.imooc.books.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: Book
 * @date 2018/12/25 20:03
 */
@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private Integer bookId;

    private String  bookName;

    private Integer bookNumber;

    private Integer bookPrice;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private LocalDate bookDate;
}
