package com.github.morningwn.t0001_t0500.t0001_t0100.t0031_t0040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author morningwn
 */
public class T0040 {

    @Test
    public void test() {

//        int[] nums = {2,3,6,7};
//        Out.println( combinationSum2( nums, 7 ) );

//        int[] nums1 = {2,3,5};
//        Out.println( combinationSum2( nums1, 7 ) );

//        int[] nums2 = {10,1,2,7,6,1,1,5};
//        Out.println( combinationSum2( nums2, 8 ) );

//        int[] nums3 = {10, 1, 2, 7, 6, 1, 2, 1, 2, 3, 4, 4, 35, 5, 6, 2, 6, 67, 5, 4323};
//        Out.println(combinationSum2(nums3, 8));

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        Arrays.sort(candidates);

        Out.println(Arrays.toString(candidates));

        generate(0, 0, target, candidates, list, res);

        return res;
    }

    public void generate(int index, int sum, int target, int[] nums, LinkedList<Integer> list, List<List<Integer>> res) {

//        Out.println("index:" + index + "\t sum:" + sum + "\t list:" + list);
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = index; i < nums.length; ) {
            int j = 0;

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                list.addLast(nums[i]);
                sum += nums[i];

                j++;
                i++;
            }

            list.addLast(nums[i]);
            sum += nums[i];

            j++;
            i++;

            for (int k = j; k > 0; k--) {
                generate(i, sum, target, nums, list, res);

                sum -= list.removeLast();
            }
        }
    }
}
