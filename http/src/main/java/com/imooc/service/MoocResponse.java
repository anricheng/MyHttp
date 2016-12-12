package com.imooc.service;

/**
 * @author nate
 */

public abstract class MoocResponse<T> {

    public abstract void success(MoocRequest request, T data);

    public abstract void fail(int errorCode, String errorMsg);

}
