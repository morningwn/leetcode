package com.github.morningwn.t0501_t1000.t0601_t0700.t0651_t0660;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-k-closest-elements/">658. 找到 K 个最接近的元素</a>
 *
 * @author morningwn
 * @create in 2022/8/25 19:13
 */
public class T0658 {

    @Test
    public void test() {
        int[] arr = { 0, 2, 4, 6, 8, 10};
        Out.println(binarySearch(arr, 11));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        return new ArrayList<>();
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            Out.printf("l:%d, r:%d, m:%d\n", left, right, middle);
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                if (middle - 1 < 0 || nums[middle - 1] < target) {
                    return middle;
                } else {
                    right = middle -1;
                }
            } else {
                if (middle + 2 > nums.length || nums[middle + 1] > target) {
                    return middle + 1;
                } else {
                    left = middle + 1;
                }
            }
        }

        return -1;
    }
}
