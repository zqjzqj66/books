package com.imooc.books.controoler.page;

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
public class PageController {

    @GetMapping("/ha")
    public String index(){
        return "/page/ha";
    }
}
