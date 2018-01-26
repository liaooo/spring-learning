package com.liao.example.controller;

import com.liao.example.bean.DemoBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(produces = "text/plain;charset=utf-8")
    public @ResponseBody String index(HttpServletRequest request) {
        return "Url:" + request.getRequestURI() + " accessed";
    }

    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=utf-8")
    public @ResponseBody String pathvar(@PathVariable String str, HttpServletRequest request) {
        return "Url:" + request.getRequestURI() + " accessed. path var:" + str;
    }

    @RequestMapping(value = "/reqparam", produces = "text/plain;charset=utf-8")
    public @ResponseBody String reqparam(Long id, HttpServletRequest request) {
        return "Url:" + request.getRequestURI() + " accessed. req var:" + id;
    }

    @RequestMapping(value = "/getobj", produces = "application/json;charset=utf-8")
    public @ResponseBody Object getObj(HttpServletRequest request) {
        DemoBean bean = new DemoBean(1L,"liao");
        return bean;
    }

    @RequestMapping(value = "/putobj",
            produces = "application/json;charset=utf-8",
            method = RequestMethod.POST)
    public @ResponseBody Object putObj(DemoBean obj, HttpServletRequest request) {
        DemoBean bean = new DemoBean(obj.getId() + 1,obj.getName());
        return bean;
    }
}
