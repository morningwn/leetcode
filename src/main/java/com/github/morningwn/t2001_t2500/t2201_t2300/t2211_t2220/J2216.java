package com.github.morningwn.t2001_t2500.t2201_t2300.t2211_t2220;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * <a href="https://leetcode.cn/problems/minimum-deletions-to-make-array-beautiful/">2216. 美化数组的最少删除数</a>
 *
 * @author morningwn
 * @date
 */
public class J2216 {

    @Test
    public void test() {
        int[] nums;
        nums = new int[]{1, 1, 2, 3, 5};
        Out.println(minDeletion(nums));  // 1

        nums = new int[]{1, 1, 2, 2, 3, 3};
        Out.println(minDeletion(nums));  // 2

        nums = new int[]{1,1,2,2,3,3,3,4,5,6,7,8,9,0,23,34,545,56,67,23,44,66,76,87,3,23,435,65,767,45,65,45,65,76,32,4345,566,76,8789,3434,546,767,87,5656,56,34,4545,65,76};
        Out.println(minDeletion(nums));  // 3

        nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Out.println(minDeletion(nums));  // 0

        Random random = new Random();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < 64059; i++) {
            tmp.add(random.nextInt(342));
        }
        System.out.println(tmp);
    }

    public int minDeletion(int[] nums) {
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < nums.length) {
            if (count % 2 == 0) {
                if (nums[j] != nums[i]) {
                    count += 2;
                    j = i + 1;
                    i++;
                }
            } else {
                count++;
            }
            i++;
        }
        return nums.length + 1 - count - (count % 2 == 0 ? 1 : 0);
    }
}
