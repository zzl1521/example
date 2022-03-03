package com.zzl.example.test;

/**
 * @author: zhile.zhang
 * @date: 2020/9/12
 * @desc:
 **/
public class Test2 {

    private static int[] arr = {1, 2, 3, 3, 4, 5, 6, 7};

    /**
     * 有可能多张同面值实效日期不一样的劵，需要优先选择实效日期最近的劵
     * 找最后一个等于值
     * [1,3,3]  取第二个3
     *
     * @param key
     * @return
     */
    public static int lastEqualsKey(int [] states, int key) {
        int lo = 0;
        int length = states.length;
        int hi = length - 1;
        //此处必须包含等于
        while (lo <= hi) {
            //如果是右移运算符 必须括号括起来 lo + ((hi - lo) >> 1)
            int index = lo + ((hi - lo) >> 1);
            int denomination = states[index];
            if (denomination == key) {
                int idx = index;
                while (idx + 1 <= length) {
                    int amount = states[idx];
                    if (idx + 1 == length && amount == key) {
                        return idx;
                    }
                    if (amount < states[idx + 1] && amount == key) {
                        return idx;
                    }
                    idx++;
                }
                return index;
            }
            if (denomination < key) {
                lo = index + 1;
            }
            if (denomination > key) {
                hi = index - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(lastEqualsKey(arr,3));
    }

}
