package com.aric.service;

import com.aric.HttpRequestProvider;
import com.aric.http.HttpRequest;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author aric
 * This is a thread pool to execute mutiple thread.
 * we have max size and each named thread pool
 * we can add a requst(depend on the size of runnning thread to desice execute or waiting) and finish a request
 */

public class MyThreadPool {


    private static final int MAX_REQUEST_SIZE = 60;

    private static final ThreadPoolExecutor sThreadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
        //这是一个自动增加的thread
        private AtomicInteger index = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            //we just put runnable to the thread pool and then we get customized thread from here. And a thread can be executed by thread pool.
            Thread thread = new Thread(r);
            thread.setName("http thread name is " + index.getAndIncrement());
            return thread;
        }
    });

   //这是一个双向的队列
    private Deque<MoocRequest> mRunningRequestArray = new ArrayDeque<>();

    private Deque<MoocRequest> mCachedRequestArray = new ArrayDeque<>();
    //去获取一个底层的可执行的request来将上层传递过来的request执行
    private HttpRequestProvider mRequestProvider;

    public MyThreadPool() {
        mRequestProvider = new HttpRequestProvider();
    }

    public void add(MoocRequest request) {
    // Making a judgement first after adding a new thread , to decide put this thread in cache or execute immediately
        if (mRunningRequestArray.size() > MAX_REQUEST_SIZE) {
            mCachedRequestArray.add(request);
        } else {
            doHttpRequest(request);
        }

    }


    public void doHttpRequest(MoocRequest request) {
        HttpRequest httpRequest = null;
        try {
            httpRequest = mRequestProvider.getHttpRequest(URI.create(request.getUrl()), request.getMethod());
        } catch (IOException e) {
            e.printStackTrace();
        }

        sThreadPool.execute(new HttpRunnable(httpRequest, request, this));
    }


    public void finish(MoocRequest request) {
        mRunningRequestArray.remove(request);
        if (mRunningRequestArray.size() > MAX_REQUEST_SIZE) {
            return;
        }

        if (mCachedRequestArray.size() == 0) {
            return;
        }

        Iterator<MoocRequest> iterator = mCachedRequestArray.iterator();

        while (iterator.hasNext()) {
            MoocRequest next = iterator.next();
            mRunningRequestArray.add(next);
            iterator.remove();
            doHttpRequest(next);
        }

    }
}
