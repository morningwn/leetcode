package com.github.morningwn.t3001_t3500.t3101_t3200.t3181_t3190;

import com.github.morningwn.prefab.FormatInput;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-ii">3185. 构成整天的下标对数目 II</a>
 *
 * @author morningwn
 * @date 2024-10-23 18:29:24
 */
public class J3185 {

    @Test
    public void test() {
//        int[] hours = new int[100000];
//        Random random = new Random();
//        for (int i = 0; i < hours.length; i++) {
//            hours[i] = random.nextInt(1000000000);
//        }
//        Out.toFile("/Users/mac/IdeaProjects/leetcode/target/1.json", hours);
        String str = FormatInput.readStr("/Users/mac/IdeaProjects/leetcode/target/1.json");
        int[] hours =FormatInput.stringToArray(str);

        Out.print(countCompleteDayPairs(hours));
//        System.out.println(getN(100));
    }

    public long countCompleteDayPairs(int[] hours) {

        long[] hourCount = new long[25];
        for (int hour : hours) {
            hourCount[hour % 24]++;
        }
        long count = 0;
        for (int i = 1; i < 12; i++) {
            count += hourCount[i] * hourCount[24 - i];
        }

        count += hourCount[0] * (hourCount[0] - 1) / 2;
        count += hourCount[12] * (hourCount[12] - 1) / 2;


        return count;
    }
}