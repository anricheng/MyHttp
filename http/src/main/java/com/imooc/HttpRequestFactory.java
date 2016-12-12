package com.imooc;

import com.imooc.http.HttpMethod;
import com.imooc.http.HttpRequest;

import java.io.IOException;
import java.net.URI;

/**
 * @author nate
 */

public interface HttpRequestFactory {

    HttpRequest createHttpRequest(URI uri, HttpMethod method) throws IOException;
}
