package com.zzl.example.algorithm;

/**
 * 二分查找（变相特殊值查找）
 * @author: ZhangZhiLe
 * @date: Created in 2018/10/29 16:48
 */
public class BinarySearch {


    /**
     * 查找第一个大于给定值
     *
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/29 16:52
     * @param:
     */
    public static int firstGreaterThan(int[] arr, int num) {
        int low = 0;
        int hi = arr.length - 1;
        while (low <= hi) {
            int index = low + ((hi - low) / 2);
            if (arr[index] <= num) {
                low = index + 1;
            }
            if (arr[index] > num) {
                if (index == 0 || arr[index - 1] <= num) return index;
                else hi = index - 1;
            }
        }
        return -1;
    }


    /**
     * 等于给定值
     * @param key
     * @return
     */
    public static int firstEqualsKey(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {  //此处必须包含等于
            int index = lo + ((hi - lo) >> 1);  //如果是右移运算符 必须括号括起来 lo + ((hi - lo) >> 1)
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



    /**
     * 查找最后一个大于给定值
     * TODO 有问题
     *
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/29 16:52
     * @param:
     */
    public static int lastGreaterThan1(int[] arr, int num) {
        int low = 0;
        int hi = arr.length - 1;
        while (low <= hi) {
            int index = low + ((hi - low) >> 1);
            if (arr[index] <= num) {
                low = index + 1;
            }
            if (arr[index] > num) {
                if (arr[index - 1] <= num && arr[index] < arr[index + 1]
                        || arr[index - 1] == arr[index]) return index;
                else hi = index - 1;
            }
        }
        return -1;
    }


    /**
     * 查找最后一个大于给定值
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/29 16:52
     * @param:
     */
    public static int lastGreaterThan(int[] arr, int num) {
        int low = 0;
        int hi = arr.length - 1;
        while (low <= hi) {
            int index = low + ((hi - low) >> 1);
            if (arr[index] <= num) {
                low = index + 1;
            }
            if (arr[index] > num) {
                hi = index - 1;
            }
            /*if (arr[index] == num) {
                return index;
            }*/
        }
        if (hi == arr.length - 1)
            return -1;
        return hi + 1;
    }


    /**
     * 查找第一个等于给定值
     *
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/29 16:52
     * @param:
     */
    public static int firstEqualsThan(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int index = low + ((high - low) >> 1);
            if (arr[index] > num) {
                high = index - 1;
            }
            if (arr[index] < num) {
                low = index + 1;
            }
            if (arr[index] == num && arr[index - 1] < num) {
                return index;
            }

        }
        return -1;
    }


    /**
     * 4 5 6 1 2 3
     * 循环数组的二分查找
     *
     * @author: ZhangZhiLe
     * @date: Created in 2018/10/29 16:52
     * @param:
     */
    public static int forEqualsThan(int[] arr, int num) {
        if (arr[0] == num) {
            return 0;
        }
        int length = arr.length;
        int low = 0;
        int high = length - 1;
        //找到循环节点
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                if (arr[i] > arr[0]) {
                    low = i;
                    high = 0;
                    break;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    low = i;
                    high = low + 1;
                    break;
                }
            }
        }
        //判断第一个节点的大小位置，确定low和high的值，转变为正常有序的二分查找
        if (arr[0] < num) {
            high = low;
            low = 0;
        }
        if (arr[0] > num) {
            low = high;
            high = length - 1;
        }
        while (low <= high) {
            int index = low + ((high - low) >> 1);
            if (arr[index] > num) {
                high = index - 1;
            }
            if (arr[index] < num) {
                low = index + 1;
            }
            if (arr[index] == num) {
                return index;
            }
        }
        return -1;
    }


    //查找最后一个小于等于给定值的元素

    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 8, 9};
        System.out.println("firstEqualsKey="+firstEqualsKey(arr,3));
        System.out.println("firstGreaterThan="+firstGreaterThan(arr, 5));
        System.out.println("lastGreaterThan="+lastGreaterThan(arr, 5));
        System.out.println(firstEqualsThan(arr, 6));
        /*int[] arr1 = {2, 3, 4, 5, 6, 8, 9, 1};
        System.out.println("----------\n" + forEqualsThan(arr1, 5));
        System.out.println(forEqualsThan(arr1, 6));
        System.out.println(forEqualsThan(arr1, 8));
        System.out.println(forEqualsThan(arr1, 9));
        System.out.println(forEqualsThan(arr1, 1));
        System.out.println(forEqualsThan(arr1, 2));
        System.out.println(forEqualsThan(arr1, 3));
        System.out.println(forEqualsThan(arr1, 4));*/
    }

}
