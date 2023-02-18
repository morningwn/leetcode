package com.github.morningwn.t1001_t1500.t1301_t1400;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据数字二进制下 1 的数目排序
 *
 * @author morningwn
 * @date 2020/11/6 19:14
 */
public class T1356 {

    @Test
    public void test() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Out.println(Arrays.toString(sortByBits(nums)));

//        int a = 123123;
//        Out.println(Integer.toString(a, 2));
//
//        int count = 0;
//        for (int i = 1; a >= i; i = i << 1) {
//            count += ((a & i) == 0 ? 0 : 1);
//        }
//        Out.println(count);
    }


    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        list.sort(
                (x, y) -> {
                    int count0 = 0;
                    int count1 = 0;

                    for (int i = 1; x >= i; i = i << 1) {
                        count0 += ((x & i) == 0 ? 0 : 1);
                    }
                    for (int i = 1; y >= i; i = i << 1) {
                        count1 += ((y & i) == 0 ? 0 : 1);
                    }
                    Out.println(x + "\t y" + y + "\t count0: " + count0 + "\t count1" + count1);
                    if (count0 != count1) {
                        return Integer.compare(count0, count1);
                    } else {
                        return Integer.compare(x, y);
                    }
                }
        );

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
