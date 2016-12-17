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



        HttpUrl build = HttpUrl.parse("https://api.heweather.com/x3/weather").newBuilder().addQueryParameter("city", "shanghai")
                .addQueryParameter("key", "d17ce22ec5404ed883e1cfcaca0ecaa7").build();
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
