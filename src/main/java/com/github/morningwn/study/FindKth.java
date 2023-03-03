package com.github.morningwn.study;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * 寻找第K个数字
 *
 * @author morningwn
 * @date Created in 2023/3/2 17:52
 */
public class FindKth {

    @Test
    public void test() {
        int[] nums = {0, 9, 11, 5, 3, 8, 9, 0, 2, 8, 7, 2, 56, 5, 4, 3, 2, 1};
        int i = findKth(nums, 6);
        Out.println(i);
        Out.println(nums);

        Arrays.sort(nums);
        Out.println(nums);
    }

    public int findKth(int[] nums, int k) {
        return findKth(nums, 0, nums.length - 1, k);
    }

    private int findKth(int[] nums, int start, int end, int k) {
        int base = nums[start];
        int l = start;
        int r = end;
        while (l < r) {
            while (l < r && base <= nums[r]) {
                r--;
            }
            swap(nums, l, r);
            while (l < r && nums[l] <= base) {
                l++;
            }
            swap(nums, l, r);
        }

        if (nums.length - r > k) {
            return findKth(nums, r + 1, end, k);
        } else if (nums.length - r == k) {
            return nums[r];
        } else {
            return findKth(nums, start, r - 1, k);
        }

    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
