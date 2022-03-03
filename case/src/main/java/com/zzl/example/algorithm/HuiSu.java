package com.zzl.example.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhile.zhang
 * @date: 2019/10/17
 * @desc:
 **/
public class HuiSu {

    public static int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值


    public static List<Integer> elList = new ArrayList<>();
    public static Map elMap = new HashMap();


    public static void main(String[] args) {
        int[] items = {10, 13, 20, 30, 41, 45, 75};
        fun(0, 0, items, items.length, 100);
        System.out.println(maxW);
        System.out.println(JSONObject.toJSONString(elMap));
    }


    // cw 表示当前已经装进去的物品的重量和；i 表示考察到哪个物品了；
    // w 背包重量；items 表示每个物品的重量；n 表示物品个数
    // 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)
    public static void fun(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) { // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
            if (cw > maxW) {
                System.out.println("cw=" + cw);
                System.out.println("maxW=" + maxW);
                maxW = cw;

                List list=new ArrayList();
                list.addAll(elList);
                System.out.println("==========="+JSONObject.toJSONString(list));
                elMap.put(maxW,list);
                elList.clear();
            }
            System.out.println("物品总重量=" + cw);
            return;
        }
        fun(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            elList.add(i);
            fun(i + 1, cw + items[i], items, n, w);
        }
    }




}
