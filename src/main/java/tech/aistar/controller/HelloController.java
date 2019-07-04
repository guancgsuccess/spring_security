package tech.aistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:https://www.cnblogs.com/zhoukebo/p/9674361.html
 * @date 2019/7/1 0001
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello,spring-security";
    }
    @GetMapping("/hello1")
    public String hello1(){

        return "hello,spring-security=====";
    }
    @GetMapping("/hello/user")
  //  @PreAuthorize("hasAnyRole('user,admin')")
    public String user(HttpServletRequest request){
        System.out.println("controller..."+request.getAttribute("claim"));
        return "hello,user";
    }
    @GetMapping("/hello/admin")
   // @PreAuthorize("hasAnyRole('admin')")
    public String admin(HttpServletRequest request){
        System.out.println("controller..."+request.getAttribute("claim"));
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return "hello,admin";
    }
}
