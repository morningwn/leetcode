package com.github.morningwn.t0001_t0500.t0201_t0300.t0261_t0270;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 丑数 II
 *
 * @author morningwn
 * @version 1.0.0
 * @date 2021/4/10 17:34
 */
public class T0264 {

    @Test
    public void test() {
        int n = 6;

        Out.println(nthUglyNumber(n));
    }

    /**
     * 优化算法，因为已经知道取第N个数,可以使用一个统一的数组保存数据
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int l2 = 0;
        int l3 = 0;
        int l5 = 0;

        for (int i = 0; i < n - 1; i++) {
            int num2 = nums[l2] * 2;
            int num3 = nums[l3] * 3;
            int num5 = nums[l5] * 5;

            int num = Math.min(num2, Math.min(num3, num5));
            if (num == num2) {
                l2++;
            }
            if (num == num3) {
                l3++;
            }
            if (num == num5) {
                l5++;
            }
            nums[i] = num;
        }

        return nums[n - 1];
    }

    /**
     * 使用三个队列，保存历史的数子，每次的丑数均为队列中的数据乘以2/3/5之后的最小值
     *
     * @param n
     * @return
     */
    public int nthUglyNumber1(int n) {
        Queue<Integer> l2 = new LinkedList<>();
        Queue<Integer> l3 = new LinkedList<>();
        Queue<Integer> l5 = new LinkedList<>();
        l2.offer(1);
        l3.offer(1);
        l5.offer(1);

        int res = 1;
        for (int i = 0; i < n - 1; i++) {
            int num2 = l2.peek() * 2;
            int num3 = l3.peek() * 3;
            int num5 = l5.peek() * 5;

            if (num2 < num3) {
                if (num2 < num5) {
                    // num2最小
                    res = num2;
                    l2.poll();
                } else if (num2 == num5) {
                    // num2 = num5 < num3
                    res = num2;
                    l2.poll();
                    l5.poll();
                } else {
                    // num5 < num2 < num3
                    res = num5;
                    l5.poll();
                }
            } else if (num2 == num3) {
                if (num2 < num5) {
                    // num2 = num3 < num5
                    res = num2;
                    l2.poll();
                    l3.poll();
                } else if (num2 == num5) {
                    // num2 = num5 = num3
                    res = num2;
                    l2.poll();
                    l3.poll();
                    l5.poll();
                } else {
                    //num5 < num2 = num3
                    res = num5;
                    l5.poll();
                }
            } else {
                // num3 < num2
                if (num2 < num5) {
                    // num3 < num2 < num5
                    res = num3;
                    l3.poll();
                } else if (num2 == num5) {
                    // num3 < num2 = num5
                    res = num3;
                    l3.poll();
                } else {
                    // num2 最大
                    if (num3 < num5) {
                        // num3 < num5 < num2
                        res = num3;
                        l3.poll();
                    } else if (num3 == num5) {
                        // num3 = num5 < num2
                        res = num3;
                        l3.poll();
                        l5.poll();
                    } else {
                        // num5 < num3 < num2
                        res = num5;
                        l5.poll();
                    }
                }
            }

            l2.offer(res);
            l3.offer(res);
            l5.offer(res);
        }

        return res;
    }
}
