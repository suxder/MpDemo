package com.jac.mpdemo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

    /**
     *  相当于一个总的异常管理器
     */
    @ExceptionHandler(Exception.class)
    public HashMap<String, Object> exceptionAdvice(Exception e) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("state", 0);
        hashMap.put("msg", e.getMessage());
        hashMap.put("data", null);

        return hashMap;
    }
}
