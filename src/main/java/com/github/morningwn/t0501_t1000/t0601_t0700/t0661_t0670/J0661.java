package com.github.morningwn.t0501_t1000.t0601_t0700.t0661_t0670;

/**
 * <a href="https://leetcode.cn/problems/image-smoother">661. 图片平滑器</a>
 *
 * @author morningwn
 * @date 2024-11-14 14:29:24
 */
public class J0661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        if (i + k >= 0 && i + k < m && j + l >= 0 && j + l < n) {
                            sum += img[i + k][j + l];
                            count++;
                        }
                    }
                }
                res[i][j] = sum / count;
            }
        }

        return res;
    }
}