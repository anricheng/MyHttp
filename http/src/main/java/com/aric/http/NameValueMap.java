package com.aric.http;

import java.util.Map;

/**
* @author aric
*/

public interface NameValueMap<K, V> extends Map<K, V> {

public String get(String name);


public void set(String name, String value);


public void setAll(Map<String, String> map);
}

