package com.example.assigment_shoes.filter;

import com.example.assigment_shoes.entity.Enum.user.RoleEnum;
import com.example.assigment_shoes.entity.Users;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class adminInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(

                HttpServletRequest request,
                HttpServletResponse response,
                Object handler

        )throws Exception{

            Object object = request.getSession().getAttribute("userLogged");
            Users users = (Users) object;

            if(users == null){

                //chưa login
                response.sendRedirect(request.getContextPath() + "/login");
                return false;

            }
            if(users.getRole() != RoleEnum.ADMIN){

                response.setStatus(404);
                response.sendRedirect(request.getContextPath() + "/product/404");
                return false;

            }

            return true;

        }


    @Override
    public void postHandle(

            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView

    ) throws Exception {

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

        }


    @Override
    public void afterCompletion(

            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex

    )throws Exception {

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);

    }



}
