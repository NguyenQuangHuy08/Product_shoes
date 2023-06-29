package com.example.assigment_shoes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.assigment_shoes.filter.loGinInterceptor;
import com.example.assigment_shoes.filter.adminInterceptor;


@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

        registry
                .addResourceHandler("/upload/**")
                .addResourceLocations("/upload/");
    }


    //   Authorize the size web

    @Autowired
    loGinInterceptor loginInterceptor;

    @Autowired
    adminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        //chỉ xem
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/checkout", "/profile","/product/list","/category/list");


        //Phân quyền bắt đăng nhập
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/**", "/product/create", "/product/edit/{id}","/category/create","/category/edit/{id}","/product/delete/{id}","/category/delete/{id}");

      }


    //how to code all language




}




