package com.github.morningwn.t0001_t0500.t0101_t0200.t0161_t0170;

/**
 * @author morningwn
 * @description: 两数之和 II - 输入有序数组
 * @date Created in 2020/7/20 17:42
 * @version: 1.0
 */
public class T0167 {

    /**
     * @author morningwn
     * @date 2020/7/20 17:46
     * @description: 双指针，从两侧向中央开始遍历整个数组，得到结果后返回
     * @param: numbers
     * @param: target
     * @return: int[]
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }

        return new int[]{-1, -1};
    }
}
