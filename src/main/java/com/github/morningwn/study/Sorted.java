package com.github.morningwn.study;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 排序算法
 *
 * @author morningwn
 * @date Created in 2023/3/3 20:16
 */
public class Sorted {

    @Test
    public void test() {
        int[] nums = {0, 9, 11, 5, 3, 8, 9, 0, 2, 8, 7, 2, 56, 5, 4, 3, 2, 1};
        bubbleSort(nums);
        Out.println(nums);
        nums = new int[]{0, 9, 11, 5, 3, 8, 9, 0, 2, 8, 7, 2, 56, 5, 4, 3, 2, 1};
        quickSort(nums);
        Out.println(nums);
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序辅助方法
     *
     * @param nums
     * @param start
     * @param end
     */
    private void quickSortHelper(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }
        int base = nums[start];
        int l = start;
        int r = end;
        while (l != r) {
            while (l < r && base <= nums[r]) {
                r--;
            }
            swap(nums, l, r);
            while (l < r && base >= nums[l]) {
                l++;
            }
            swap(nums, l, r);
        }
        quickSortHelper(nums, start, l - 1);
        quickSortHelper(nums, r + 1, end);
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
