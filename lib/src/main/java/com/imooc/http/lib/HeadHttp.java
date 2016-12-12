package com.imooc.http.lib;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author nate
 */
public class HeadHttp {

    public static void main(String args[]) {
        String str = "1234";

        System.out.println(str.substring(0,str.length() - 3));


        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().
                url("http://www.imooc.com/static/sea-modules/seajs/seajs/2.1.1/sea.js").
                addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.71 Safari/537.36").
                addHeader("Range", "bytes=2-").
                addHeader("Accept-Encoding", "identity").
                build();
        try {
            Response response = client.newCall(request).execute();


//            System.out.println(response.body().string());
            System.out.println("size=" + response.body().contentLength());
            System.out.println("type=" + response.body().contentType());
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
