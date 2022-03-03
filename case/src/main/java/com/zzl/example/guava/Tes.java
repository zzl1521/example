package com.zzl.example.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @author: zhile.zhang
 * @date: 2020/8/20
 * @desc:
 **/
public class Tes {

    private final LoadingCache<String, String> cache = CacheBuilder.newBuilder().build(new ExpensiveCacheLoader());

    public static void main(String... args) {
        new Tes().run();
    }

    private void run() {
        // Start 2 threads concurrently accessing the same key in the cache
        for (int i = 0; i < 2; i++) {

            new Thread(() -> {
                String key = cache.getUnchecked("key");
                System.out.println("www=" + key);
            }).start();
        }
    }

    private static class ExpensiveCacheLoader extends CacheLoader<String, String> {
        @Override
        public String load(String key) throws Exception {
            // Make the computation "expensive" by sleeping for 60s
            Thread.sleep(6000);
            return key;
        }
    }
}
