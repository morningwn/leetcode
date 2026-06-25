package com.github.morningwn.t1501_t2000.t1501_t1600.t1501_t1510;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/last-moment-before-all-ants-fall-out-of-a-plank/">1503. 所有蚂蚁掉下来前的最后一刻</a>
 *
 * @author morningwn
 * @date Created in 2020/7/5 10:35
 */
public class J1503 {

    @Test
    public void test() {
        int n = 4;
        int[] left = {4, 3};
        int[] right = {0, 1};

        Out.println(getLastMoment(n, left, right));
    }

    public int getLastMoment(int n, int[] left, int[] right) {

        Arrays.sort(left);
        Arrays.sort(right);
        int countTime = 0;

        if (left != null && left.length != 0) {
            countTime = left[left.length - 1];
        }
        if (right != null && right.length != 0) {
            countTime = Math.max(countTime, n - right[0]);
        }
        return countTime;

//        int[] mark = new int[7+1];
//        boolean stop = false;
//
//        for (int num : left) {
//            mark[num] = -1;
//        }
//        for (int num : right) {
//            if (mark[num] == -1) {
//                mark[num] = 2;
//            }else {
//                mark[num] = 1;
//            }
//        }
//
//
//        while (!stop) {
//            countTime++;
//            int[] tmp = new int[n+1];
//            stop = true;
//            for (int i = 0; i <= n; i++) {
//                if (mark[i] == 1) {
//                    if (i < n) {
//                        tmp[i+1] = tmp[i+1] == 0 ? 1 : 2;
//                        stop = false;
//                    }
//                }else if (mark[i] == -1) {
//                    if (i > 0) {
//                        tmp[i-1] = tmp[i-1] == 0 ? -1 : 2;
//                        stop = false;
//                    }
//                }else if (mark[i] == 2) {
//                    if (i > 0 && i < n) {
//                        tmp[i+1] = tmp[i+1] == 0 ? 1 : 2;
//                        tmp[i-1] = tmp[i-1] == 0 ? -1 : 2;
//                        stop = false;
//                    }else if (i <= 0 && i < n) {
//                        tmp[i+1] = tmp[i+1] == 0 ? 1 : 2;
//                        stop = false;
//                    }else if (i > 0 && i >= n) {
//                        tmp[i-1] = tmp[i-1] == 0 ? -1 : 2;
//                        stop = false;
//                    }
//                }
//            }
//        }
//
//        return countTime;
    }

}
