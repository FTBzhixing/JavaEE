package com.ftb.async.Utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil {

    private final static int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static ThreadPoolExecutor POOL_EXECUTOR;

    private ThreadPoolUtil() {
    }

    public static ThreadPoolExecutor getExecutor() {
        if (null == POOL_EXECUTOR) {
            synchronized (ThreadPoolUtil.class) {
                if (null == POOL_EXECUTOR) {
                    POOL_EXECUTOR = new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
                            AVALIABLE_PROCESSORS * 2, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(5),
                            new ThreadPoolExecutor.CallerRunsPolicy());
                }
            }
        }
        return POOL_EXECUTOR;
    }



    public static void closeThreadPool(ThreadPoolExecutor executor) {
        if (null != executor) {
            executor.shutdown();
        }
    }
}
