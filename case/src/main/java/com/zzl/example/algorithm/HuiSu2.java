package com.zzl.example.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhile.zhang
 * @date: 2019/10/17
 * @desc:
 **/
public class HuiSu2 {

    private int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值
    // 下标表示物品序号，值表示是否放进背包:1放，0不放
    private int[] currentAnswer;
    //存储所有解(map key表示放进去的重量，value表示对应重量的物品放法)，
    //最终所有最优解为bestAnswerMap.get(maxW)
    private Map<Integer, List<int[]>> bestAnswerMap = new HashMap();

    public static void main(String[] args) {
        HuiSu2 huiSu2 = new HuiSu2();
        int[] items = {10, 13, 20, 30, 41, 45, 75};
        huiSu2.f(0, 0, items, items.length, 100);
        System.out.println(huiSu2.maxW);
        List<int[]> ints = huiSu2.bestAnswerMap.get(huiSu2.maxW);
        for (int[] ints1:ints){
            for (int i : ints1) {
                System.out.println(i);
            }
        }
    }




    // cw 表示当前已经装进去的物品的重量和；i 表示考察到哪个物品了；
    // w 背包重量；items 表示每个物品的重量；n 表示物品个数
    // 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)
    public void f(int i, int cw, int[] items, int n, int w) {
        if(currentAnswer == null){
            currentAnswer = new int[n];
        }

        if (cw == w || i == n) { // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
            if (cw >= maxW) {
                maxW = cw;
                int[] bestAnswer = new int[currentAnswer.length];
                for(int j=0; j<currentAnswer.length; j++){
                    bestAnswer[j] = currentAnswer[j];
                }
                if(bestAnswerMap.containsKey(cw)){
                    bestAnswerMap.get(cw).add(bestAnswer);
                }else{
                    List<int[]> list = new ArrayList<int[]>();
                    list.add(bestAnswer);
                    bestAnswerMap.put(cw, list);
                }
            }
            return;
        }
        currentAnswer[i] = 0;
        f(i+1, cw, items, n, w);
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            currentAnswer[i] = 1;
            f(i+1,cw + items[i], items, n, w);
        }
    }
}
