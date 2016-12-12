package com.imooc.http.download;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author nate
 */
public class RangHttp {




    public static void main(String args[]) {


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.qq.com").
                addHeader("Accept-Encoding","identity").
                addHeader("Range", "bytes=0-").
                build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println("content-length : "+response.body().contentLength());
            if (response.isSuccessful()) {
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    System.out.println(headers.name(i) + " : " + headers.value(i));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
