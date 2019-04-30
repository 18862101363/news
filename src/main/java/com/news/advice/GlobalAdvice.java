package com.news.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by dong_zhengdong on 2019/4/30.
 */
@ControllerAdvice
@Slf4j
public class GlobalAdvice {

    private final String ERROR_VIEW = "error";


    /**
     * For handing [[Exception]] MissingServletRequestParameterException
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ModelAndView handleMissingServletRequestParameterException(Exception exception) {
        ModelAndView mv = new ModelAndView(ERROR_VIEW);
        mv.addObject("exception", exception.getMessage());
        return mv;
    }



}
