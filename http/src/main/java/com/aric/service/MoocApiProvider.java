package com.aric.service;

import com.aric.http.HttpMethod;
import com.aric.service.convert.Convert;
import com.aric.service.convert.JsonConvert;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author aric
 * 很多请求中其实含有一些共性的东西，放在这里直接去实现这些请求
 */

public class MoocApiProvider {

    public static void setUatUrl(String uatUrl) {

        UAT_URL = uatUrl;

    }

    public static  String  UAT_URL="www.baidu.com";

    private static final String ENCODING = "utf-8";

    private static MyThreadPool sMyThreadPool = new MyThreadPool();

    private static final List<Convert> sConverts = new ArrayList<>();

    static {
        sConverts.add(new JsonConvert());
    }

//针对get请求进行密码加密
    public static byte[] encodeParam(Map<String, String> value) {
        if (value == null || value.size() == 0) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        int count = 0;
        try {
            for (Map.Entry<String, String> entry : value.entrySet()) {

                buffer.append(URLEncoder.encode(entry.getKey(), ENCODING)).append("=").
                        append(URLEncoder.encode(entry.getValue(), ENCODING));
                if (count != value.size() - 1) {
                    buffer.append("&");
                }
                count++;

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return buffer.toString().getBytes();
    }

    public static void helloWorld(Map<String, String> value, MoocResponse response) {
        // a request /a thread pool/a response call back,this is what we need
        MoocRequest request = new MoocRequest();
        WrapperResponse wrapperResponse = new WrapperResponse(response, sConverts);
        request.setUrl(UAT_URL);
        request.setMethod(HttpMethod.POST);
        request.setData(encodeParam(value));
        request.setResponse(wrapperResponse);
        sMyThreadPool.add(request);
    }


    public static void helloWeather(MoocResponse response){
        MoocRequest weatherRequest = new MoocRequest();

        weatherRequest.setUrl("https://api.heweather.com/x3/weather?city=shanghai&key=d17ce22ec5404ed883e1cfcaca0ecaa7");
        weatherRequest.setMethod(HttpMethod.GET);
        WrapperResponse wrapperResponse = new WrapperResponse(response, sConverts);
        weatherRequest.setResponse(wrapperResponse);
        sMyThreadPool.add(weatherRequest);

    }

}
