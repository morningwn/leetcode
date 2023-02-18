package com.github.morningwn.t0501_t1000.t0901_t1000.t0911_t0920;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/sort-an-array/">912. 排序数组</a>
 *
 * @author moringwn
 * @create in 2020/12/7 16:07
 */
public class T0912 {

    @Test
    public void test() {
        int[] nums = {-4, 0, 7, 4, 9, -5, -1, 0, -7, -1};

        Out.println(Arrays.toString(sortArray(nums)));
    }

    //折半插入排序
    public int[] sortArray(int[] nums) {

        List<Integer> list = new ArrayList<>(nums.length);

        for (int num : nums) {

            int l = 0;
            int r = list.size() - 1;

            while (l <= r) {
                int middle = (r + l) / 2;

                if (list.get(middle) > num) {
                    if (middle - 1 >= l && list.get(middle - 1) < num) {
                        l = middle;
                        break;
                    } else {
                        r = middle - 1;
                    }
                } else if (list.get(middle) < num) {
                    if (middle + 1 < r && list.get(middle + 1) > num) {
                        l = middle + 1;
                        break;
                    } else {
                        l = middle + 1;
                    }
                } else {
                    l = middle;
                    break;
                }

            }

            list.add(l, num);

        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    //冒泡排序，超时了
    public int[] sortArray1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        return nums;
    }
}
