package com.aric;

import com.aric.http.HttpHeader;
import com.aric.http.HttpRequest;
import com.aric.http.HttpResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author aric
 */

public abstract class AbstractHttpRequest implements HttpRequest {

    private static final String GZIP = "gzip";
//这里的header只是给了一个map 集合并没有任何的赋值，可以增加一个赋值的方法去进行赋值
    private HttpHeader mHeader = new HttpHeader();

    private ZipOutputStream mZip;

    private boolean executed;

    @Override
    public HttpHeader getHeaders() {
        return mHeader;
    }

    @Override
    public OutputStream getBody() {
        OutputStream body = getBodyOutputStream();
        if (isGzip()) {

            return getGzipOutStream(body);
        }
        return body;
    }

    private OutputStream getGzipOutStream(OutputStream body) {
        //在每次执行execute 之前都会将这个流关闭，所以每次去获取的时候都是重新开的这个流
        if (this.mZip == null) {
            this.mZip = new ZipOutputStream(body);
        }
        return mZip;
    }

    private boolean isGzip() {

        String contentEncoding = getHeaders().getContentEncoding();
        if (GZIP.equals(contentEncoding)) {
            return true;
        }
        return false;
    }

    @Override
    public HttpResponse execute() throws IOException {
        if (mZip != null) {
            mZip.close();
        }
        //
        HttpResponse response = executeInternal(mHeader);
        executed = true;
        return response;
    }
//这里将这个值暴露给下层，由下层来进行赋值
    protected abstract HttpResponse executeInternal(HttpHeader mHeader) throws IOException;

    protected abstract OutputStream getBodyOutputStream();
}
