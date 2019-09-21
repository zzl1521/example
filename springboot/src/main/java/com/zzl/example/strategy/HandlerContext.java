package com.zzl.example.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: zhile.Zhang
 * @date: 2019/9/21
 * @desc: 此类不能自动用@Component注册否则手动注册不上去
 **/
public class HandlerContext {

    private Map<String, Class> handlerMap = new ConcurrentHashMap<>();

    public void putHandler(String type, Class clazz) {
        handlerMap.put(type, clazz);
    }

    public Class getInstant(String type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("type [" + type + "] illegal");
        }
        return clazz;
    }

}
