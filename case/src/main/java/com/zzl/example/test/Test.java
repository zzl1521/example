package com.zzl.example.test;

/**
 * @author: zhile.zhang
 * @date: 2020/9/12
 * @desc:
 **/
public class Test {
    private static int[] arr = {1, 2, 3, 4, 5, 6, 7};
    public static int get(int key) {
        int lo = 0;
        int hi = arr.length - 1;
        //此处必须包含等于
        while (lo <= hi) {
            //如果是右移运算符 必须括号括起来 lo + ((hi - lo) >> 1)
            int index = lo + ((hi - lo) >> 1);
            if (arr[index] == key) {
                return index;
            }
            if (arr[index] < key) {
                lo = index + 1;
            }
            if (arr[index] > key) {
                hi = index - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(get(3));
    }

}
