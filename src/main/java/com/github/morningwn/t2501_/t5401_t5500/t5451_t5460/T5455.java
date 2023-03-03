package com.github.morningwn.t2501_.t5401_t5500.t5451_t5460;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author morningwn
 * @description: 最多 K 次交换相邻数位后得到的最小整数
 * @date Created in 2020/7/5 11:29
 * @version: 1.0
 */
public class T5455 {

    private char[] min;

    @Test
    public void test() {
        Out.println(minInteger("4321", 4));
    }

    public String minInteger(String num, int k) {
        char[] nums = num.toCharArray();
        min = num.toCharArray();
        helper(nums, k, 0);

        StringBuilder sb = new StringBuilder();
        for (char n : min) {
            sb.append(n);
        }
        return sb.toString();
    }

    public void helper(char[] nums, int k, int index) {
        if (index >= nums.length - 1 || k <= 0) {
            return;
        }
        Out.println(k + "\t " + index + "\t " + Arrays.toString(nums));

        swap(nums, index, index + 1);
        if (!compareNums(min, nums)) {
            min = Arrays.copyOf(nums, nums.length);
        }
        for (int i = 0; i < nums.length; i++) {
            helper(nums, k - 1, i);
        }
        swap(nums, index + 1, index);
        for (int i = 1; i < nums.length; i++) {
            helper(nums, k, index + i);
        }
    }

    public void swap(char[] nums, int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public boolean compareNums(char[] num1, char[] num2) {
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] > num1[2]) {
                return false;
            }
        }

        return true;
    }

}
