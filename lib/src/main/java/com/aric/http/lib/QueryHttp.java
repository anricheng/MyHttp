package com.aric.http.lib;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author aric
 */
public class QueryHttp {

    public static void main(String args[]) {



        HttpUrl build = HttpUrl.parse("http://127.0.0.1:3000/");
        Request request = new Request.Builder().url(build).build();

        OkHttpClient okHttpClient = new OkHttpClient();
        try {
            Response execute = okHttpClient.newCall(request).execute();
            if(execute.isSuccessful()){
                System.out.print(execute.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
