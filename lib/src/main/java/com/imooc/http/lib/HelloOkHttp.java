package com.imooc.http.lib;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author nate
 */
public class HelloOkHttp {

    public static void main(String args[]) {
        OkHttpClient client = new OkHttpClient();


        RequestBody body=RequestBody.create(null,new byte[0]);
        Request request = new Request.Builder().
                url("http://www.imooc.com").method("GET",null).build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
