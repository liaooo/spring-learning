package com.liao.example.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice 声明一个控制器全局建言
 * 在Controller类的方法上添加一下方法的注解使用
 */
@ControllerAdvice
public class GlobalHandleAdvice {

    /**
     * 全局异常处理
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(Exception ex, WebRequest request) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorMessage", ex.getMessage());
        return mv;
    }

    /**
     * 将键值对添加到全局
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "message");
    }

    /**
     * 定制WebDataBinder
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }
}
