package com.github.morningwn.to_offer.t011_t020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/7/3 13:07
 */
public class T0013 {

    @Test
    public void test() {

        Out.println(movingCount1(100, 99, 20));

        Out.println(movingCount(100, 99, 20));
    }

    /**
     * @author morningwn
     * @date 2020/7/3 15:37
     * @description: 递归算法，只去能够到达的地方
     * @param: m 输入m
     * @param: n 输入n
     * @param: k 输入k
     * @return: int 返回能够到达的格子数量
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] isvisited = new boolean[m][n];

        return helper(m, n, 0, 0, isvisited, k);
    }

    /**
     * @author morningwn
     * @date 2020/7/3 15:38
     * @description: 递归，先判断当前位置能否到达，然后再进入下一格
     * @param: m 输入m
     * @param: n 输入n
     * @param: i 标记当前在那一行
     * @param: j 标记当前在那一列
     * @param: isvisited 标记是否去过的数组
     * @param: k 最大的距离
     * @return: int 结果
     */
    public int helper(int m, int n, int i, int j, boolean[][] isvisited, int k) {
        int dis = getNumLength(i) + getNumLength(j);
        if (i >= m || j >= n || isvisited[i][j] || dis > k) {
            return 0;
        }

        isvisited[i][j] = true;
        return helper(m, n, i + 1, j, isvisited, k) + helper(m, n, i, j + 1, isvisited, k) + 1;

    }

    /**
     * @author morningwn
     * @date 2020/7/3 15:01
     * @description: 根据图遍历得到结果
     * @version: 1.0
     * @param: m 行
     * @param: n 列
     * @param: k 范围
     * @return: int 能够到达的格子数
     */
    public int movingCount1(int m, int n, int k) {
        int count = 1;
        boolean[][] map = new boolean[m + 2][n + 2];
        map[1][1] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int dis = getNumLength(i - 1) + getNumLength(j - 1);
                if (dis <= k && (map[i - 1][j] || map[i + 1][j] || map[i][j - 1] || map[i][j + 1])) {
                    count++;
                    map[i][j] = true;
                }
            }
        }

        return count;
    }

    /**
     * @author morningwn
     * @date 2020/7/3 14:53
     * @description: 获取输入数的各个位数和
     * @param: num 输入一个数
     * @return: int 返回其各位的和
     */
    public int getNumLength(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num = num / 10;
        }
        return res;
    }

}
