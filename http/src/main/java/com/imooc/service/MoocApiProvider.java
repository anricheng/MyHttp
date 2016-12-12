package com.imooc.service;

import com.imooc.http.HttpMethod;
import com.imooc.service.convert.Convert;
import com.imooc.service.convert.JsonConvert;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author nate
 */

public class MoocApiProvider {

    private static final String ENCODING = "utf-8";

    private static WorkStation sWorkStation = new WorkStation();

    private static final List<Convert> sConverts = new ArrayList<>();

    static {
        sConverts.add(new JsonConvert());
    }


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

    public static void helloWorld(String ul, Map<String, String> value, MoocResponse response) {
        MoocRequest request = new MoocRequest();
        WrapperResponse wrapperResponse = new WrapperResponse(response, sConverts);
        request.setUrl(ul);
        request.setMethod(HttpMethod.POST);
        request.setData(encodeParam(value));
        request.setResponse(wrapperResponse);
        sWorkStation.add(request);
    }

}
