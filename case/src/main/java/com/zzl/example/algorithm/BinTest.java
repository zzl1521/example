package com.zzl.example.algorithm;

/**
 * @author: zhile.zhang
 * @date: 2019/10/20
 * @desc:
 **/
public class BinTest {

    /**
     * 找最后一个等于值
     * [1,3,3]  取第二个3
     *
     * @param key
     * @return
     */
    public static int lastEqualsKey(int[] arr, int key) {
        int lo = 0;
        int length = arr.length;
        int hi = length - 1;
        //此处必须包含等于
        while (lo <= hi) {
            //如果是右移运算符 必须括号括起来 lo + ((hi - lo) >> 1)
            int index = lo + ((hi - lo) >> 1);
            if (arr[index] == key) {
                int idx = index;
                while (idx + 1 <= length) {
                    if (idx + 1 == length && arr[idx] == key) {
                        return idx;
                    }
                    if (arr[idx] < arr[idx + 1] && arr[idx] == key) {
                        return idx;
                    }
                    idx++;
                }
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


    /**
     * 优先返回最后一个等于的指定值 否则 返回最后一个小于指定值
     * [1,1,3,3]
     * 参数： 3 返回 index=3
     * 参数： 2 返回 index=1
     *
     * @param key
     * @return
     */
    public static int lastLessThan(int[] arr, int key) {
        int lo = 0;
        int length = arr.length;
        int hi = length - 1;
        //此处必须包含等于
        while (lo <= hi) {
            //如果是右移运算符 必须括号括起来 lo + ((hi - lo) >> 1)
            int index = lo + ((hi - lo) >> 1);
            if (arr[index] == key) {
                int idx = index;
                while (idx + 1 <= length) {
                    if (idx + 1 == length && arr[idx] == key) {
                        return idx;
                    }
                    if (arr[idx] < arr[idx + 1] && arr[idx] == key) {
                        return idx;
                    }
                    idx++;
                }
                return index;
            }
            if (arr[index] < key) {
                lo = index + 1;
            }
            if (arr[index] > key) {
                hi = index - 1;
            }
        }
        System.out.println("小于lo=" + lo);
        //最后一个小于给定值
        if (lo > length - 1) {
            return length - 1;
        }

        int idx = lo;
        while (idx >= 0 && idx < length) {
            if (arr[idx] < key) {
                if (idx == length - 1) {
                    return idx;
                }
                if (arr[idx] < key && arr[idx + 1] > key) {
                    return idx;
                }
            }
            if (arr[idx] > key) {
                idx--;
            } else {
                idx++;
            }
        }
        return -1;
    }

    /**
     * 优先返回最后一个等于的指定值 否则 返回第一个大于指定值
     * [1,1,3,3]
     * 参数： 3 返回 index=3
     * 参数： 2 返回 index=1
     *
     * @param key
     * @return
     */
    public static int firstGreaterThan(int[] arr, int key) {
        int lo = 0;
        int length = arr.length;
        int hi = length - 1;
        //此处必须包含等于
        while (lo <= hi) {
            //如果是右移运算符 必须括号括起来 lo + ((hi - lo) >> 1)
            int index = lo + ((hi - lo) >> 1);
            if (arr[index] == key) {
                int idx = index;
                while (idx + 1 <= length) {
                    if (idx + 1 == length && arr[idx] == key) {
                        return idx;
                    }
                    if (arr[idx] < arr[idx + 1] && arr[idx] == key) {
                        return idx;
                    }
                    idx++;
                }
                return index;
            }
            if (arr[index] < key) {
                lo = index + 1;
            }
            if (arr[index] > key) {
                hi = index - 1;
            }
        }
        //第一个大于给定值
        int idx = hi;
        while (idx < length) {
            if (arr[idx] > key) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 6, 6, 7, 8, 8, 9, 9};
        System.out.println("firstEqualsKey=" + lastEqualsKey(arr, 1));
        System.out.println("firstEqualsKey=" + lastEqualsKey(arr, 3));
        System.out.println("firstEqualsKey=" + lastEqualsKey(arr, 4));
        System.out.println("firstEqualsKey=" + lastEqualsKey(arr, 6));
        System.out.println("firstEqualsKey=" + lastEqualsKey(arr, 8));
        System.out.println("firstEqualsKey=" + lastEqualsKey(arr, 9));
        System.out.println("firstEqualsKey=" + lastEqualsKey(arr, 11));
        System.out.println("firstEqualsKey=" + lastEqualsKey(arr, 15));

        System.out.println("-----------------------------------------");
        System.out.println("lastLessThan=" + lastLessThan(arr, 4));
        System.out.println("lastLessThan=" + lastLessThan(arr, 11));
        System.out.println("lastLessThan=" + lastLessThan(arr, 15));

        System.out.println("-----------------------------------------");
        System.out.println("firstGreaterThan=" + firstGreaterThan(arr, 4));
        System.out.println("firstGreaterThan=" + firstGreaterThan(arr, 11));
        System.out.println("firstGreaterThan=" + firstGreaterThan(arr, 15));

        int[] arr2 = {13, 15, 21, 30, 30, 45, 61, 61};
        System.out.println("firstEqualsKey=" + lastEqualsKey(arr2, 13));
    }
}
