package com.github.morningwn.t2501_t3000.t2901_t3000.t2951_t2960;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-the-peaks/description/">2951. 找出峰值</a>
 * 
 * @author morningwn
 * @date 2024-05-28 11:10:24
 */
public class J2951 {
    
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> peakList = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) {
                peakList.add(i);
            }
        }
        return peakList;
    }
}