package com.imooc.books.controoler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: PageController
 * @date 2018/12/26 12:38
 */
@Controller
@RequestMapping(value = "page")
public class PageController {

    @GetMapping("/ha")
    public ModelAndView index(){
        return new ModelAndView("ha");
    }
}
