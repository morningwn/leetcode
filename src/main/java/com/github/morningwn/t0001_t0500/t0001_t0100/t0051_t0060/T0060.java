package com.github.morningwn.t0001_t0500.t0001_t0100.t0051_t0060;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 第k个排列
 *
 * @author morningwn
 * @date 2020/9/5  10:42
 */
public class T0060 {

    @Test
    public void test() {
        int n = 3;
        int k = 6;

        Out.println(getPermutation(n, k));
    }

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        StringBuilder sb = new StringBuilder(n);

        helper(nums, k, n, sb);

        return sb.toString();
    }

    public void helper(int[] nums, int k, int n, StringBuilder sb) {
        if (n == 0) {
            return;
        }

        int tmp = getFac(n - 1);

        int index = 0;
        int next = 0;
        for (int l = 0, r = tmp; ; l += tmp, r += tmp) {
            if (l < k && k <= r) {
                break;
            }
            index++;
        }

        if (index == 0) {
            next = k;
        } else if (index == 1) {
            next = k - tmp;
        } else {
            next = k - (index) * tmp;
        }

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                continue;
            }
            if (j == index) {
                nums[i] = 1;
                sb.append(i + 1);
                break;
            }
            j++;
        }

        helper(nums, next, n - 1, sb);
    }

    public int getFac(int n) {
        if (n > 0) {
            return n * getFac(n - 1);
        } else {
            return 1;
        }
    }
}
