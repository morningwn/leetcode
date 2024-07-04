package com.github.morningwn.t3001_t3500.t3001_t3100.t3081_t3090;

import com.github.morningwn.prefab.Out;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/minimum-moves-to-pick-k-ones/description/">3086. 拾起 K 个 1 需要的最少行动次数</a>
 *
 * @author morningwn
 * @date 2024/7/3 14:18
 */
public class J3086 {

    @Test
    public void test() {
        Assert.assertEquals(3L, minimumMoves(new int[]{1, 1, 0, 0, 0, 1, 1, 0, 0, 1}, 3, 1));
        Assert.assertEquals(4L, minimumMoves(new int[]{0,0,0,0}, 2, 3));
        Assert.assertEquals(58L, minimumMoves(new int[]{1,1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,1,0,1,0,1,0,1,0,1,1,1,0,0,1,0,1,0,1}, 12, 1));

//        Out.print(buildCase(100000));
//        minimumMoves(buildCase(100000), 10000, 10000);
    }

    private int[] buildCase(int count) {
        Random random = new Random();

        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = random.nextInt(2);
        }

        return nums;
    }
    public long minimumMoves(int[] nums, int k, int maxChanges) {
        long minimumMoves = Long.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            long moveCount = getMoves(nums, k, i, maxChanges, minimumMoves);
            if (moveCount < minimumMoves) {
                minimumMoves = moveCount;
            }
        }
        return minimumMoves;
    }

    private long getMoves(int[] nums, int k, int index, int maxChanges, long minimumMoves) {
        if (nums[index] == 1) {
            k--;
        }

        int left = index - 1;
        int right = index + 1;
        long moveCount = 0;

        while (k > 0) {
            long leftCount = Long.MAX_VALUE;
            long rightCount = Long.MAX_VALUE;
            boolean flag = false;
            if (moveCount > minimumMoves) {
                return Long.MAX_VALUE;
            }
            
            if ((index - left >= 2 && right - index >= 2 )&& maxChanges >= k) {
                return moveCount + k * 2;
            }
            
            if (left > -1) {
                if (nums[left] == 1) {
                    leftCount = index - left;
                    flag = true;
                }
            }
            if (right < nums.length) {
                if (nums[right] == 1) {
                    rightCount = right - index;
                    flag = true;
                }
            }

             if (flag) {
                k--;
                if (leftCount > rightCount) {
                    moveCount += rightCount;
                    right++;
                } else {
                    moveCount += leftCount;
                    left--;
                }
            } else {
                right++;
                left--;
            }
        }

        return moveCount;

    }
}