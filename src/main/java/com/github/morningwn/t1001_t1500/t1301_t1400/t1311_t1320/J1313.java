package com.github.morningwn.t1001_t1500.t1301_t1400.t1311_t1320;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.ArrayList;


/**
 * <a href="https://leetcode.cn/problems/decompress-run-length-encoded-list/">1313. 解压缩编码列表</a>
 * <ul>
 * <li>{@link Difficulty#Easy}</li>
 * <li>{@link Topic#Array}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2020.01.12 22:55
 */
public class J1313 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        //输出：[2,4,4,4]

        for (int i : decompressRLElist(nums)) {
            Out.print(i + "\t");
        }
    }

    public int[] decompressRLElist(int[] nums) {

//        int tmp = 1;
//
//        for ( int i = 0; 2*i+1 < nums.length; i++ ){
//            tmp *= nums[2*i];
//        }
//        int[] output = new int[tmp];
//
//        int count = 0;
//        for ( int i = 0; 2*i+1 < nums.length; i++ ){
//            for ( int j = 0; j < nums[2*i]; j++ ){
//                output[count++] = nums[2*i+1];
//            }
//        }
//
//        return output;

        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; 2 * i + 1 < nums.length; i++) {
            for (int j = 0; j < nums[2 * i]; j++) {
                output.add(nums[2 * i + 1]);
            }
        }

        int[] result = new int[output.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = output.get(i);
        }

        return result;
    }
}
