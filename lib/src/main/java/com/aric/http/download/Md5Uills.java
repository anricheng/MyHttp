package com.aric.http.download;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author aric
 */
public class Md5Uills {

    public static void main(String args[]) {
        System.out.println(generateCode("http://www.imooc.com"));

        try {
            Class.forName("com.imooc.http.download.RangHttp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static String generateCode(String url) {
//        if (TextUtils.isEmpty(url)) {
//            return null;
//        }

        StringBuffer buffer = new StringBuffer();
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            digest.update(url.getBytes());
            byte[] cipher = digest.digest();
            for (byte b : cipher) {
                String hexStr = Integer.toHexString(b & 0xff);
                buffer.append(hexStr.length() == 1 ? "0" + hexStr : hexStr);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
