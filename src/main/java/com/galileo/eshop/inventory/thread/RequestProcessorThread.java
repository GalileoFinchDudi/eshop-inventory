package com.galileo.eshop.inventory.thread;

import com.galileo.eshop.inventory.request.Request;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

/**
 * 执行请求的工作线程
 * @author galileo
 * @ClassName RequestProcessorThread
 * @Description TODO
 * @Date 2020/3/15 16:34
 * @Version 1.0
 **/
public class RequestProcessorThread implements Callable<Boolean> {

    private ArrayBlockingQueue<Request> queue;

    public RequestProcessorThread(ArrayBlockingQueue<Request> queue) {
        this.queue = queue;
    }

    @Override
    public Boolean call() throws Exception {
        while (true){
            break;
        }
        return true;
    }

}
