package com.zzl.example.algorithm;

/**
 * @author: zhile.zhang
 * @date: 2019/10/20
 * @desc:
 **/
public class DongTaiGuiHua {

    private int n;
    private int[] items;
    private int w;

    public DongTaiGuiHua(int n, int[] items, int w) {
        this.n = n;
        this.items = items;
        this.w = w;
    }

    public static void main(String[] args) {
        /*int[] items = new int[1000];
        for (int i = 0; i < 1000; i++) {
            int amount = (int) (Math.random() * 200);
            if (amount <= 0) {
                amount = (int) (Math.random() * 200);
            }
            items[i] = amount;
        }*/
        int[] items = {2, 2, 3, 4, 6};
        new DongTaiGuiHua(items.length,items,6).lessThanKeyMaxVal(dynamicProgramming(items, items.length, 6));
    }

    // items 商品价格，n 商品个数, w 表示满减条件，比如 200
    public static boolean[][] dynamicProgramming(int[] items, int n, int w) {
        // 超过 3 倍就没有薅羊毛的价值了
        boolean[][] states = new boolean[n][3 * w + 1];
        // 第一行的数据要特殊处理
        states[0][0] = true;
        if (items[0] <= 3 * w) {
            states[0][items[0]] = true;
        }
        // 动态规划
        for (int i = 1; i < n; ++i) {
            // 不购买第 i 个商品
            for (int j = 0; j <= 3 * w; ++j) {
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }
            // 购买第 i 个商品
            for (int j = 0; j <= 3 * w - items[i]; ++j) {
                if (states[i - 1][j] == true) states[i][j + items[i]] = true;
            }
        }
        return states;
    }

    public void lessThanKeyMaxVal(boolean[][] states) {
        int j;
        for (j = w; j > 0; j--) {
            // 输出结果大于等于 w 的最小值
            if (states[n - 1][j] == true) break;
        }
        // 没有可行解
        if (j == 3 * w + 1) return;
        // i 表示二维数组中的行，j 表示列
        for (int i = n - 1; i >= 1; --i) {
            if (j - items[i] >= 0 && states[i - 1][j - items[i]] == true) {
                // 购买这个商品
                System.out.print(items[i] + " ");
                j = j - items[i];
            } // else 没有购买这个商品，j 不变。
        }
        if (j != 0) System.out.print(items[0]);
    }


    public void greaterThanKeyMinVal(boolean[][] states) {
        int j;
        for (j = w; j < 3 * w + 1; ++j) {
            // 输出结果大于等于 w 的最小值
            if (states[n - 1][j] == true) break;
        }
        // 没有可行解
        if (j == 3 * w + 1) return;
        // i 表示二维数组中的行，j 表示列
        for (int i = n - 1; i >= 1; --i) {
            if (j - items[i] >= 0 && states[i - 1][j - items[i]] == true) {
                // 购买这个商品
                System.out.print(items[i] + " ");
                j = j - items[i];
            } // else 没有购买这个商品，j 不变。
        }
        if (j != 0) System.out.print(items[0]);
    }


}
