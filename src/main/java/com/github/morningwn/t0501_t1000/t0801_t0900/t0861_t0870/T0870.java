package com.github.morningwn.t0501_t1000.t0801_t0900.t0861_t0870;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/advantage-shuffle/">870. 优势洗牌</a>
 *
 * @author morningwn
 * @create in 2022/10/8 14:52
 */
public class T0870 {

    @Test
    public void test() {
        int[] nums1 = {12,24,8,32};
        int[] nums2 = {13,25,32,11};
        int[] res = advantageCount(nums1, nums2);
        Out.println(res);
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 排序
        Arrays.sort(nums1);
        int[] res = new int[nums1.length];
        int minIndex = 0;

        for (int i = 0; i < nums2.length; i++) {
            int val = -1;
            int minVal = -1;
            int index = minIndex;
            while (index < nums1.length) {
                if (nums1[index] == -1) {
                    index++;
                    continue;
                }
                if (minVal == -1) {
                    minVal = nums1[index];
                    minIndex = index;
                }
                if (nums1[index] > nums2[i]) {
                    val = nums1[index];
                    nums1[index] = -1;
                    break;
                }
                index++;
            }
            if (val != -1) {
                res[i] = val;
            } else {
                res[i] = minVal;
                nums1[minIndex] = -1;
            }
        }

        return res;
    }
}
