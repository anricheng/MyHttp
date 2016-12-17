package com.aric.http.lib;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author aric
 */
public class PostHttp {
    public static void main(String args[]) {


        new Thread(){

            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                //if we use FormBody to create a request , the params will be encoded ,be care of blank space and all the char will be encoded
                //according to the ASCII sheet.
                FormBody body = new FormBody.Builder()
                        .add("username","aric")
                        .add("userage","20")
                        .build();
                Request request = new Request.Builder()
                        .url("http://localhost:8080/web/HelloServlet")
                        .post(body)
                        .build();

                try {
                    Response execute = okHttpClient.newCall(request).execute();
                    if (execute.isSuccessful()) {

                        System.out.print(execute.body().toString());

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        new Thread() {

            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                FormBody body = new FormBody.Builder().add("username", "nate")
                        .add("userage", "99").build();
                Request request = new Request.Builder().url("http://localhost:8080/web/HelloServlet").post(body).build();
                try {
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        System.out.println(response.body().string());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }.start();
    }
}
