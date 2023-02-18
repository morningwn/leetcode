package com.github.morningwn.to_offer.t061_t070;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 山峰数组的顶部
 *
 * @author moringwn
 * @date 2021/10/14 上午9:29
 */
public class T069II {

    @Test
    public void test() {
        int[] array = {19, 26, 36, 67, 78, 79, 99, 100, 89, 84};

        Out.println(peakIndexInMountainArray(array));
    }

    public int peakIndexInMountainArray(int[] arr) {

        int l = 0, r = arr.length - 1;
        int m = 0;

        while (l < r) {
            m = (l + r) / 2;
            Out.println(l + "\t" + r);
            if (arr[l] > arr[m]) {
                if (arr[m] > arr[r]) {
                    r = m - 1;
                } else {
                    if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) {
                        return m;
                    } else {
                        l++;
                        r--;
                    }
                }
            } else {
                if (arr[m] > arr[r]) {
                    if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) {
                        return m;
                    } else {
                        l++;
                        r--;
                    }
                } else {
                    l = m + 1;
                }
            }

        }

        return l;
    }
}
