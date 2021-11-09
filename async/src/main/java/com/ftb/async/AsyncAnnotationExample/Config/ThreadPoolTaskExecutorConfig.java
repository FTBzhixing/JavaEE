package com.ftb.async.AsyncAnnotationExample.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//@Configuration

@PropertySource("classpath:application.properties")
public class ThreadPoolTaskExecutorConfig {

    @Value("${threadPoolTaskExecutor.corePoolSize}")
    private int corePoolSize;

    @Value("${threadPoolTaskExecutor.maxPoolSize}")
    private int maxPoolSize;

    @Value("${threadPoolTaskExecutor.queueCapacity}")
    private int queueCapacity;

    @Bean(name="ThreadPoolExecutor")
    public ThreadPoolExecutor getThreadPoolExecutor(){
        return new ThreadPoolExecutor(corePoolSize,maxPoolSize,1L, TimeUnit.DAYS,new ArrayBlockingQueue<>(25));
    }
}
