package com.aric.http.lib;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author aric
 */
public class MultipartHttp {

    public static void main(String args[]) {

// if we use the multipart way to create a request ,the params will not be encoded.


        RequestBody imageBody = RequestBody.create(MediaType.parse("image/jpeg"), new File("/Users/nate/girl.jpg"));
        MultipartBody body = new MultipartBody.Builder().
                setType(MultipartBody.FORM).
                addFormDataPart("name", "nate").
                addFormDataPart("filename", "girl.jpg", imageBody).build();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().
                url("http://192.168.1.6:8080/web/UploadServlet").post(body).build();
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
