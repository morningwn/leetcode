package com.github.morningwn.t2001_t2500.t2101_t2200.t2191_t2200;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/find-all-k-distant-indices-in-an-array">2200. 找出数组中的所有 K 近邻下标</a>
 *
 * @author morningwn
 * @date 2025-06-24 18:43:59
 */
public class J2200 {

    @Test
    public void test() {
        List<Integer> indices = findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1);
        Out.print(indices);
//        [1,2,3,4,5,6
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> indices = new ArrayList<>();
        int bf = 0;
        for(int i = 0; i < nums.length; i++) {
            if (deque.size() > k) {
                deque.pollFirst();
            }
            if (nums[i] == key) {
                if (!deque.isEmpty()) {
                    indices.addAll(deque);
                    deque.clear();
                }
                indices.add(i);
                bf = k;
            } else {
                if (bf > 0) {
                    bf--;
                    indices.add(i);
                } else {
                    deque.addLast(i);
                }
            }
        }

        return indices;
    }
}