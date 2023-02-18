package com.github.morningwn.t0001_t0500.t0101_t0200.t0121_t0130;


import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @description: 最长连续序列
 * @date Created in 2020/6/6 10:11
 * @version: 1.0
 */
public class T0128 {
    @Test
    public void test() {
//        int[] nums = {-1, 1, 0};
//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1, 2};
        Out.println(longestConsecutive(nums));
    }
//    public int longestConsecutive(int[] nums) {
//        Set<Integer> nums_set = new HashSet<>();
//        for (int num : nums) {
//            nums_set.add(num);
//        }
//
//        int maxlen = 0;
//        int nex = 0;
//        for (int num : nums_set) {
//
//        }
//    }

    public int longestConsecutive(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for (int num : nums) {
            int size = list.size();
            boolean insert = false;
            for (int i = 0; i < size; i++) {
                List<Integer> tmp = list.get(i);
                if (tmp.get(tmp.size() - 1) == num - 1) {
                    tmp.add(num);
                    insert = true;
                    break;
                } else if ((i == 0 || (i > 0 && list.get(i - 1).get(list.get(i - 1).size() - 1) < num)) && tmp.get(0) > num) {
                    list.add(i, new ArrayList<Integer>() {{
                        add(num);
                    }});
                    insert = true;
                    size++;
                    break;
                }
            }
            if (!insert && ((size > 0 && list.get(size - 1).get(list.get(size - 1).size() - 1) < num) || size == 0)) {
                list.add(new ArrayList<Integer>() {{
                    add(num);
                }});
            }
            for (int i = 0; i < size - 1; i++) {
                List<Integer> tmp = list.get(i);
                List<Integer> nex = list.get(i + 1);
                if (tmp.get(tmp.size() - 1) == nex.get(0) - 1) {
                    tmp.addAll(nex);
                    list.remove(i + 1);
                    break;
                }
            }

        }

        int maxlen = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() > maxlen) {
                maxlen = list.get(i).size();
            }
        }

        return maxlen;
    }

}
