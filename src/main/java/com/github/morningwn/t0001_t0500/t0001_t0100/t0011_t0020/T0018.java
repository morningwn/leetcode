package com.github.morningwn.t0001_t0500.t0001_t0100.t0011_t0020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T0018 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();        //结果集

        //对数组排序
        Arrays.sort(nums);

        for (int m = 0; m < nums.length - 3; m++) {
            for (int n = m + 1; n < nums.length - 2; n++) {

                int l = n + 1, r = nums.length - 1;

                while (l < r) {

                    int sum = nums[m] + nums[n] + nums[l] + nums[r];

                    if (sum > target) {
                        while (r > 0 && nums[r] == nums[--r]) {
                        }
                    } else if (sum < target) {
                        while (l < nums.length - 1 && nums[l] == nums[++l]) {
                        }
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[m]);
                        list.add(nums[n]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);

                        while (r > 0 && nums[r] == nums[--r]) {
                        }
                        while (l < nums.length - 1 && nums[l] == nums[++l]) {
                        }

                    }
                }

                //在对n进行加一的时候跳过所有相同的数
                while (n < nums.length - 2 && nums[n] == nums[n + 1]) {
                    n++;
                }
            }

            //在对m进行加一的时候跳过所有相同的数
            while (m < nums.length - 3 && nums[m] == nums[m + 1]) {
                m++;
            }
        }

        return result;
    }

    @Test
    public void test() {

        int[] nums = {1, 0, -1, 0, -2, 2};
        Out.println(fourSum(nums, 0));     //[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
    }
}
