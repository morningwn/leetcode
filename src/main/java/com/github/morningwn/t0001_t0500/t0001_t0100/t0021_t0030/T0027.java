package com.github.morningwn.t0001_t0500.t0001_t0100.t0021_t0030;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/remove-element/">27. 移除元素</a>
 *
 * @author morningwn
 * @date Created in
 */
public class T0027 {

    @Test
    public void test() {

/*        int[] nums = { 3,2,2,3 };
        Out.println( removeElement(nums, 3 ) );

        for ( int i : nums )
            Out.print( i +"\t");*/

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        Out.println(removeElement(nums, 2));

        for (int i : nums) {
            Out.print(i + "\t");
        }

    }

    public int removeElement(int[] nums, int val) {

        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }

        return len + 1;
    }
}
