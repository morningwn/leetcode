package com.github.morningwn.t2501_.t5401_t5500.t5491_t5500;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date 2020/8/30  10:33
 */
public class T5499 {

    @Test
    public void test() {

        int[] arr = {6, 3, 5, 5, 5, 5, 1, 5, 6, 2, 5, 1, 2, 5, 3, 5, 1, 3, 5, 5, 6, 4, 1, 2};
        int m = 1;
        int k = 5;
        Out.println(containsPattern(arr, m, k));
    }

    public boolean containsPattern(int[] arr, int m, int k) {
        boolean res = false;

        for (int i = 0; i < arr.length; i++) {
            res = true;
            for (int j = 1; j < k; j++) {
                for (int a = 0; a < m; a++) {
                    int index0 = i + a;
                    int index1 = i + a + j * m;
                    if (index0 >= arr.length || index1 >= arr.length) {
                        res = false;
                        break;
                    }
                    if (arr[index0] != arr[index1]) {
                        res = false;
                        break;
                    }
                }
                if (!res) {
                    break;
                }
            }
            if (res) {
                return res;
            }
        }

        return res;
    }
}
