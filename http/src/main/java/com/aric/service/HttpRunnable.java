package com.aric.service;

import com.aric.http.HttpRequest;
import com.aric.http.HttpResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author aric  多线程我需要实现多个
 */

public class HttpRunnable implements Runnable {
//为何要传递进来两个httprequest 因为一个是上层的用来传递一些请求的参数，一个是下层的最终去发送一个请求的对象
    private HttpRequest mHttpRequest;

    private MoocRequest mRequest;
//拥有一个workStation的引用是为了将这个任务给结束掉，所以传递的时候直接传递的就是this这个参数
    private MyThreadPool mMyThreadPool;

    public HttpRunnable(HttpRequest httpRequest, MoocRequest request, MyThreadPool myThreadPool) {
        this.mHttpRequest = httpRequest;
        this.mRequest = request;
        this.mMyThreadPool = myThreadPool;

    }

    @Override
    public void run() {
        try {
           // mHttpRequest.getBody().write(mRequest.getData());
            HttpResponse response = mHttpRequest.execute();
            String contentType = response.getHeaders().getContentType();
            mRequest.setContentType(contentType);
            if (response.getStatus().isSuccess()) {
                if (mRequest.getResponse() != null) {//其实这个response 只是在刚开始请求的时候传递给request的用来作为回调的对象
                    //所以在这里通过调用这个response中的回调函数就将这里的数据最终传递给了调用的地方
                    mRequest.getResponse().success(mRequest, new String(getData(response)));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            mMyThreadPool.finish(mRequest);
        }


    }

    public byte[] getData(HttpResponse response) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream((int) response.getContentLength());
        int len;
        byte[] data = new byte[512];
        try {
            while ((len = response.getBody().read(data)) != -1) {
                outputStream.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
