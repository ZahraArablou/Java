package com.spring.capp.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String helloWorld() {
        return "hello";// ->/WEB-INF/view/hello.jsp

    }

    @RequestMapping("/test/ajax_test")
    public String testpage() {
        return "test";

    }

    @RequestMapping("/test/get_time")
    @ResponseBody //generally d.tostrimg is a jsp file but with this line we want to write the date directly in out put string
    public String getServerTime() {
        System.out.println("----------getServerTime()-----------");
        Date d = new Date();
        return d.toString();

    }
}
