package com.imooc.books.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: ShopConfig
 * @date 2018/12/26 10:37
 */
@Configuration
public class ShopConfig implements WebMvcConfigurer {

    /**
     *
     * Description: 对一些静态资源的再次配置, 似乎是由于 spring boot 2.0 以后导致的一些关于资源访问的问题
     *
     * @Title: addResourceHandlers
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
         //静态资源配置
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        // swagger api 配置
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
         //webjars 配置
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        // 本地文件访问
        //registry.addResourceHandler("/files/**").addResourceLocations("classpath:/files/");
    }


    /**
     * Description: 页面转向
     *
     * @Title: addViewControllers
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index.html");
        registry.addViewController("/index.page").setViewName("/index.html");
    }

   /* @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }*/

}
