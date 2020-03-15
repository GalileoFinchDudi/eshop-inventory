package com.galileo.eshop.inventory.thread;

import com.galileo.eshop.inventory.request.Request;
import com.galileo.eshop.inventory.request.RequestQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 请求处理线程池：单例
 * @author galileo
 * @ClassName ThreadPool
 * @Description TODO
 * @Date 2020/3/15 16:01
 * @Version 1.0
 **/
public class RequestProcessorThreadPool {

    // 在实际项目中，设置线程池大小多少，每个线程监控的队列大小
    // 都应该写到一个外部配置文件中

    /**
     * 线程池
     */
    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public RequestProcessorThreadPool() {
        RequestQueue requestQueue = RequestQueue.getInstance();

        for(int i = 0; i < 10; i++){
            ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(100);
            requestQueue.addQueue(queue);
            threadPool.submit(new RequestProcessorThread(queue));
        }

    }

    /**
     * 单例模式有很多方式去实现，这里采用的是绝对线程安全的一种方式
     *
     * 静态内部类的方式，去初始化单例
     */
    private static class Singleton {

        private static RequestProcessorThreadPool instance;

        static {
            instance = new RequestProcessorThreadPool();
        }

        public static RequestProcessorThreadPool getInstance() {
            return instance;
        }

    }

    /**
     *
     * jvm机制去保障多线程并发安全
     *
     * 内部类的初始化，一定只会发生一次，不管多少个线程并发去初始化
     *
     * @return
     */
    public static RequestProcessorThreadPool getInstance(){
        return Singleton.getInstance();
    }

    /**
     * 初始化的便捷方法
     */
    public static void init() {
        getInstance();
    }
}
