package com.aric.service.convert;

import com.aric.http.HttpResponse;

import java.io.IOException;

import java.lang.reflect.Type;

/**
 * @author aric
 */

public interface Convert {

    Object parse(HttpResponse response, Type type) throws IOException;

    boolean isCanParse(String contentType);

    Object parse(String content, Type type) throws IOException;
}
