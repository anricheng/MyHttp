package com.aric.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * @author aric
 */
//一个http 请求包含请求的方法  请求的uri 请求的body 以及这个请求的返回response
public interface HttpRequest extends Header {

    HttpMethod getMethod();

    URI getUri();

    OutputStream getBody();

    HttpResponse execute() throws IOException;

}
