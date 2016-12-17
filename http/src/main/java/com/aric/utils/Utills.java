package com.aric.utils;

/**
 * @author aric
 */

public class Utills {


    public static boolean isExist(String className, ClassLoader loader) {
        try {
            //new 一个对象跟获取到一个类的class 对象之后去newInstance的区别就是，new可以直接new,但是newInstance需要首先获得类加载器并且已经连接到这个类
            //Class.forName（）就是起到这个作用。
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
