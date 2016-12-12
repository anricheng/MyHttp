package com.imooc.download.http;

import java.io.File;

/**
 * @author nate
 */
public interface DownloadCallback {

    void success(File file);

    void fail(int errorCode, String errorMessage);

    void progress(int progress);
}
