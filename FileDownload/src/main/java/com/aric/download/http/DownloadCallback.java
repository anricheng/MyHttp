package com.aric.download.http;

import java.io.File;

/**
 * @author aric
 */
public interface DownloadCallback {

    void success(File file);

    void fail(int errorCode, String errorMessage);

    void progress(int progress);
}
