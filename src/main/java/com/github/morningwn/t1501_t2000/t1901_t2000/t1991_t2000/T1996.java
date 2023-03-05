package com.github.morningwn.t1501_t2000.t1901_t2000.t1991_t2000;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/">1996.游戏中弱角色的数量</a>
 *
 * @author morningwn
 * @date 2022/01/28 下午3:26
 */
public class T1996 {

    @Test
    public void test() {
        // int[][] properties = { { 5, 5 }, { 6, 3 }, { 3, 6 } };
        int[][] properties = {{7, 9}, {10, 7}, {6, 9}, {10, 4}, {7, 5}, {7, 10}};
        // int[][] properties = { { 10, 1 }, { 5, 1 }, { 7, 10 }, { 4, 1 }, { 5, 9 }, {
        // 6, 9 }, { 7, 2 }, { 1, 10 } };

        Out.println(numberOfWeakCharacters(properties));
    }

    /**
     * 双重排序做法
     *
     * @param properties
     * @return
     */
    public int numberOfWeakCharacters(int[][] properties) {

        // 调库排序
        Arrays.sort(properties, (v1, v2) -> v1[0] != v2[0] ? v2[0] - v1[0] : v1[1] - v2[1]);

        // 双层冒泡排序，复杂度n*n
        // for (int i = 0; i < properties.length; i++) {
        // for (int j = i + 1; j < properties.length; j++) {
        // if (properties[i][0] < properties[j][0]) {
        // int tmp1 = properties[i][0];
        // int tmp2 = properties[i][1];
        // properties[i][0] = properties[j][0];
        // properties[i][1] = properties[j][1];
        // properties[j][0] = tmp1;
        // properties[j][1] = tmp2;
        // }
        // }

        // for (int j = 0; j <= i; j++) {
        // if (properties[i][0] == properties[j][0] && properties[i][1] <
        // properties[j][1]) {
        // int tmp2 = properties[i][1];
        // properties[i][1] = properties[j][1];
        // properties[j][1] = tmp2;
        // }
        // }
        // }

        int max2 = properties[0][1];
        int count = 0;

        for (int i = 1; i < properties.length; i++) {
            if (max2 > properties[i][1]) {
                ++count;
            } else {
                max2 = properties[i][1];
            }
        }

        return count;
    }
}
