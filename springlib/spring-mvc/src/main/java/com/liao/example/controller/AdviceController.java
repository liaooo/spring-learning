package com.liao.example.controller;

import com.liao.example.bean.DemoBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {

    @RequestMapping(value = "/advice")
    public String getMsg(@ModelAttribute("msg") String msg, DemoBean bean) {
        throw new IllegalArgumentException("Sorry, Error params " + msg);
    }
}
