package com.github.morningwn.t0001_t0500.t0001_t0100.t0051_t0060;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/3 14:57
 */
public class T0053 {

    @Test
    public void test() {

        int[] nums = {-2, 1, -3};
        Out.println(maxSubArray(nums));
    }


    /**
     * 动态规划，时间复杂度O(n)
     *
     * @param nums 一个数组
     * @return 最大的连续和
     */
    public int maxSubArray(int[] nums) {

        //计算从头到当前的值
        int count = 0;
        //存储最大的连续和
        int max = Integer.MIN_VALUE;

        //遍历整个数组
        for (int num : nums) {

            //如果当前的和大于0那就将结果累计，否则就将count置零后重新累加
            if (count > 0) {
                count += num;
            } else {
                count = num;
            }
            //将count与max的值比较，得到最大值
            max = Math.max(count, max);
        }
        return max;
    }

    /**
     * 遍历算法，时间复杂度O(n2)
     *
     * @param nums 数组
     * @return 最大连续和
     */
    public int maxSubArray1(int[] nums) {

        int[] counts = new int[nums.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                counts[j] += nums[i];
                max = Math.max(counts[j], max);
            }
        }

        return max;
    }

}
