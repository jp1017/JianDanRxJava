package com.socks.jiandan.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

public class JSONParser {

    protected static Gson gson = new Gson();

    public static Object toObject(String jsonString, Object type) {
        jsonString = jsonString.replace("&nbsp", "");
        jsonString = jsonString.replace("﹠nbsp", "");
        jsonString = jsonString.replace("nbsp", "");
        jsonString = jsonString.replace("&amp;", "");
        jsonString = jsonString.replace("&amp", "");
        jsonString = jsonString.replace("amp", "");
        if (type instanceof Type) {
            try {
                return gson.fromJson(jsonString, (Type) type);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                return null;
            }
        } else if (type instanceof Class<?>) {
            try {
                return gson.fromJson(jsonString, (Class<?>) type);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            throw new RuntimeException("只能是Class<?>或者通过TypeToken获取的Type类型");
        }
    }
}