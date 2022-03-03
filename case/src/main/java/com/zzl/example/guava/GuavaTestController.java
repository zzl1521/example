package com.zzl.example.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhile.zhang
 * @date: 2019/10/30
 * @desc: 健康监测
 **/
public class GuavaTestController {


    public static void main(String[] args) throws Exception{
        String userId = getValue("userId");

    }


    public void printDetail() {
        System.out.println("Size: " + appConfigCache.size());
    }

    public static String getValue(String key) throws ExecutionException {
        String value = appConfigCache.get(key);
        return value;
    }

    //refreshAfterWrite
    private static LoadingCache<String, String> appConfigCache = CacheBuilder.newBuilder().maximumSize(100)
            .expireAfterWrite(2, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    String keyValue = getKeyValue(key);
                    return keyValue;
                }
            });

    private static String getKeyValue(String key) throws Exception {
        Thread.sleep(60000L);
        return "时间:" + System.currentTimeMillis();
    }

}
