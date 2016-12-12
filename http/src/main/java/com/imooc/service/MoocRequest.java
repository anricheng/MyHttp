package com.imooc.service;

import com.imooc.http.HttpMethod;

/**
 * @author nate
 */

public class MoocRequest {

    private String mUrl;

    private HttpMethod mMethod;

    private byte[] mData;

    private MoocResponse mResponse;

    private String mContentType;

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public HttpMethod getMethod() {
        return mMethod;
    }

    public void setMethod(HttpMethod method) {
        mMethod = method;
    }

    public byte[] getData() {
        return mData;
    }

    public void setData(byte[] data) {
        mData = data;
    }

    public MoocResponse getResponse() {
        return mResponse;
    }

    public void setResponse(MoocResponse response) {
        mResponse = response;
    }

    public String getContentType() {
        return mContentType;
    }

    public void setContentType(String contentType) {
        mContentType = contentType;
    }
}
