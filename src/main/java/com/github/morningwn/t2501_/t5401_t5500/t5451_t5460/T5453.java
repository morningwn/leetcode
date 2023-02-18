package com.github.morningwn.t2501_.t5401_t5500.t5451_t5460;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author morningwn
 * @description: 所有蚂蚁掉下来前的最后一刻
 * @date Created in 2020/7/5 10:35
 * @version: 1.0
 */
public class T5453 {

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
