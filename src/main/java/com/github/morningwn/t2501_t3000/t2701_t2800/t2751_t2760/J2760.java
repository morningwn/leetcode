package com.github.morningwn.t2501_t3000.t2701_t2800.t2751_t2760;

import com.github.morningwn.prefab.FormatInput;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/">2760. 最长奇偶子数组</a>
 *
 * @author morningwn
 * @date 2023/11/16 11:22
 */
public class J2760 {

    @Test
    public void test() {
        int[] nums = FormatInput.stringToArray("[3,2,5,4]");
        int threshold = 5;
        Out.println(longestAlternatingSubarray(nums, threshold));
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxSubLength = 0;
        int subLength = 0;
        int flag = 1;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] <= threshold) {
                if (flag == 1 && nums[index] % 2 == 0) {
                    flag = -1;
                    subLength++;
                } else if (flag == -1 && nums[index] % 2 == 1) {
                    flag = 1;
                    subLength++;
                } else {
                    maxSubLength = Math.max(maxSubLength, subLength);
                    if (nums[index] % 2 == 0) {
                        flag = -1;
                        subLength = 1;
                    } else {
                        flag = 1;
                        subLength = 0;
                    }
                }
            } else {
                flag = 1;
                maxSubLength = Math.max(maxSubLength, subLength);
                subLength = 0;
            }
            index++;
        }
        maxSubLength = Math.max(maxSubLength, subLength);
        return maxSubLength;
    }
}
