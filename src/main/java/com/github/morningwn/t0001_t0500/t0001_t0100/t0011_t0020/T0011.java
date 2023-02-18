package com.github.morningwn.t0001_t0500.t0001_t0100.t0011_t0020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @description: 盛最多水的容器
 * @date Created in
 * @version: 2.0
 */
public class T0011 {

    @Test
    public void test() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Out.println(maxArea(height));        //49
    }

    /**
     * Double pointer method
     *
     * @param height Enter an array representing the container
     * @return maximum water capacity
     */
    public int maxArea(int[] height) {

        //
        int area = 0;
        int left = 0, right = height.length - 1;

        //traverse the array from two sides to the middle
        while (left < right) {

            //if the value of left is smaller, move it to the right
            //otherwise move the value of right to the left
            if (height[left] < height[right]) {
                area = Math.max((right - left) * height[left], area);
                left++;
            } else {
                area = Math.max((right - left) * height[right], area);
                right--;
            }
        }

        return area;
    }

    /**
     * Violence cycle method
     *
     * @param height Enter an array representing the container
     * @return maximum water capacity
     */
    public int maxArea1(int[] height) {

        int area = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = i + 1; j < height.length; j++) {

                int tmp = (j - i) * Math.min(height[i], height[j]);

                if (tmp > area) {
                    area = tmp;
                }
            }
        }

        return area;
    }

}