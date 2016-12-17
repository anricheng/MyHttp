package com.aric.http;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author aric
 * 一个response包含状态码 状态信息  输入的body 关闭 以及获得的文件的大小
 */
public interface HttpResponse extends Header, Closeable {

    HttpStatus getStatus();

    String getStatusMsg();

    InputStream getBody() throws IOException;

    void close();

    long getContentLength();

}
