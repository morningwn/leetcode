package com.github.morningwn.t0001_t0500.t0401_t0500.t0411_t0420;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 分割等和子集
 *
 * @author morningwn
 * @date 2020/10/11  8:20
 */
public class T0416 {

    @Test
    public void test() {
        for (int i = 0; i < 101; i++) {
            Out.print((int) (Math.random() * 101) + ",");
        }
    }

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        int sum = 0;
        int target;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 0) {
            target = sum / 2;
        } else {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }

        return dp[target];
    }
//    /**
//     * 算法超时
//     * @param nums
//     * @return
//     */
//    public boolean canPartition(int[] nums) {
//        Arrays.sort(nums);
//        return helper(nums, 0, 0, 0);
//    }
//
//    public boolean helper(int[] nums, int index, int sum1, int sum2) {
//
//        if (index < nums.length) {
//            int num = nums[index];
//            int count = 1;
//            while (index+1 < nums.length && num == nums[index+1]) {
//                count++;
//                index++;
//            }
//            boolean res = false;
//            for (int i = 0; i <= count && !res; i++) {
//                res = helper(nums, index+1, sum1+i*num, sum2+(count-i)*num);
//            }
//
//            return res;
//        }else {
//            return sum1 == sum2;
//        }
//
//    }
}
