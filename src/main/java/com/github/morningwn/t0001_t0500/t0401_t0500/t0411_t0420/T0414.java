package com.github.morningwn.t0001_t0500.t0401_t0500.t0411_t0420;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T0414 {

    @Test
    public void test() {

//        int[] nums = {1,2,-2147483648};
//        int[] nums = {3, 2, 1};
//        int[] nums = {2, 1};
//        int[] nums = {7, 2, 3,5 , 4, 1, 5, 3, 3, 7, 2, 1, 2, 6, 7, 4, 3, 3, 6, 5, 4, 3, 5};
//        int[] nums = {1,2,2,5,3,5};
        int[] nums = {1, -2147483648, 2};

        Out.println(thirdMax(nums));
    }

    public int thirdMax(int[] nums) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int flag = 0;

        for (int num : nums) {

            if (num > first) {
                if (second > Integer.MIN_VALUE) {
                    flag = 1;
                }
                third = second;
                second = first;
                first = num;

            } else if (num > second) {

                if (num == first) {
                    continue;
                }

                if (second > Integer.MIN_VALUE) {
                    flag = 1;
                }
                third = second;
                second = num;
            } else if (num >= third) {

                if (num == second && num > Integer.MIN_VALUE) {
                    continue;
                }
                flag = 1;
                third = num;
            }

            Out.println(first + "\t " + second + "\t " + third);

        }


        if (second == Integer.MIN_VALUE || flag == 0) {
            return first;
        } else {
            return third;
        }


    }

    //简单的
    public int thirdMax1(int[] nums) {

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>(3);

        int i = nums.length - 1;

        while (list.size() < 3 && i >= 0) {
            if (!list.contains(nums[i])) {
                list.add(nums[i--]);
            } else {
                i--;
            }
        }

        Out.println(list);

        if (list.size() == 3) {
            return list.get(2);
        } else {
            return list.get(0);
        }
    }

}
