package com.wds.app.concurrent;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.*;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-16 9:13
 */
public class ThreadPoolTest {

    @Test
    public void testThreadPool(){
        ListeningExecutorService service = null;

        try {
            ThreadPoolExecutor threadPoolExecutor = this.initThreadPoolExecutor(5);
            service = MoreExecutors.listeningDecorator(threadPoolExecutor);

            List<ListenableFuture<String>> listenableFutures = Lists.newArrayList();
            for(int i = 0; i < 20; i ++){
                final int tempI = i;
                ListenableFuture<String> listenableFuture = service.submit(() -> {
                    Thread.currentThread().setName("thread-" + tempI);
                    return Thread.currentThread().getName();
                });
                listenableFutures.add(listenableFuture);
            }

            ListenableFuture<List<String>> allFuture = Futures.allAsList(listenableFutures);
            Futures.addCallback(allFuture, new FutureCallback<List<String>>() {
                @Override
                public void onSuccess(List<String> threadName) {
                    System.out.println(threadName);
                }

                @Override
                public void onFailure(Throwable throwable) {

                }
            });
            allFuture.get(5, TimeUnit.MINUTES);
        }catch (Exception e){

        }finally{
            service.shutdown();
        }
    }

    /**
     * 初始化线程池
     * @param nThread
     * @return
     */
    private ThreadPoolExecutor initThreadPoolExecutor(int nThread){

        ArrayBlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(100000);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();

        /**
         * corePoolSize     线程池基本大小
         * maximumPoolSize  线程池最大大小
         * keepAliveTime    线程活动保持时间（当线程数大于基本大小时，此为终止多余的空闲线程等待新任务的最长时间。所以如果任务很多，并且每个任务执行的时间比较短，可以调大这个时间，提高线程的利用率。）
         * unit             时间单位
         * workQueue        等待队列
         * handler          饱和策略
         */
        return new ThreadPoolExecutor(nThread, nThread, 5, TimeUnit.SECONDS, blockingQueue, handler);
    }
}
