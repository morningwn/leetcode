package com.github.morningwn.t0001_t0500.t0001_t0100.t0031_t0040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T0039 {

    private List<List<Integer>> result;
    private int[] nums;
    private int target;

    @Test
    public void test() {

        int[] nums = {2, 3, 6, 7};
        Out.println(combinationSum(nums, 7));

        int[] nums1 = {2, 3, 5};
        Out.println(combinationSum(nums1, 7));

        int[] nums2 = {10, 1, 2, 7, 6, 1, 5};
        Out.println(combinationSum(nums2, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new ArrayList<>();
        Arrays.sort(candidates);
        nums = candidates;
        this.target = target;

//        for( int i = 0; i < nums.length; i++ ){
//            List<Integer> list = new ArrayList<Integer>();
//            list.add(nums[i]);
//            generate( i, 0, null );
//        }

        generate(0, 0, null);

        return result;
    }

    public void generate(int i, int sum, List<Integer> list) {

//        Out.println( i + " \t" + sum + " \t" + list );

        for (int j = i; j < nums.length; j++) {
            List<Integer> tmpLs;
            if (list == null) {
                tmpLs = new ArrayList<Integer>();
            } else {
                tmpLs = new ArrayList<>(list);
            }

            if (sum + nums[j] == target) {
                tmpLs.add(nums[j]);
                result.add(tmpLs);

//                Out.println( "结果输出："+ tmpLs );
            } else if (sum + nums[j] < target) {
                tmpLs.add(nums[j]);

                generate(j, sum + nums[j], tmpLs);
//                if ( j+1 < nums.length )
//                    generate( j+1, sum+nums[j], tmpLs );
            }

        }

    }
}
