package com.github.morningwn.t1001_t1500.t1201_t1300.t1291_t1300;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/find-numbers-with-even-number-of-digits/">1295. 统计位数为偶数的数字</a>
 *
 * @author moringwn
 * @date
 */
public class T1295 {

    @Test
    public void test() {

        Out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));            //2
    }

    public int findNumbers(int[] nums) {

        int result = 0;

//        for ( int i = 0; i < nums.length; i++ ){
////            if ( (nums[i]+"").length()%2 == 0 )
////                result++;
//
//            result += (nums[i]+"").length()%2 == 0 ? 1:0;
//        }
        for (int i : nums) {
            result += (i + "").length() % 2 == 0 ? 1 : 0;
        }

        return result;
    }
}
