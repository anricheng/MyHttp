package com.aric;

import com.aric.http.HttpMethod;
import com.aric.http.HttpRequest;

import java.io.IOException;
import java.net.URI;

/**
 * @author aric
 */

public interface HttpRequestFactory {

    HttpRequest createHttpRequest(URI uri, HttpMethod method) throws IOException;
}
