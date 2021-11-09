package com.ftb.async.AsyncAnnotationExample.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequestMapping(value = "/test")
public class Test {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @GetMapping(value = "/test1")
    public String test() {
        return String.valueOf(threadPoolExecutor.getCorePoolSize());
    }
}
