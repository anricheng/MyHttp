package com.aric.service;

/**
 * @author aric
 * 最终这个response是通过这个回调接口
 */

public abstract class MoocResponse<T> {

    public abstract void success(MoocRequest request, T data);

    public abstract void fail(int errorCode, String errorMsg);

}
