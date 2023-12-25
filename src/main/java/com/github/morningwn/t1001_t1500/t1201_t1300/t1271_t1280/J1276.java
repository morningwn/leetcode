package com.github.morningwn.t1001_t1500.t1201_t1300.t1271_t1280;

import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/number-of-burgers-with-no-waste-of-ingredients/">1276. 不浪费原料的汉堡制作方案</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#Math}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-12-25 11:06:49
 */
public class J1276 {

    @Test
    public void test() {

    }


    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> nums = new ArrayList<>();

        if (tomatoSlices % 2 != 0) {
            return nums;
        }

        int x = (tomatoSlices - 2 * cheeseSlices) / 2;
        int y = cheeseSlices - x;

        if (x < 0 || y < 0) {
            return nums;
        }
        nums.add(x);
        nums.add(y);
        return nums;
    }
}
