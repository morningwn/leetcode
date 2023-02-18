package com.github.morningwn.t0501_t1000.t0501_t0600;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author morningwn
 * @date Created in 2020/5/15 11:05
 */
public class T0560 {
    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -2, 1};
        Out.println(subarraySum(nums, 3));
        Out.println(subarraySum1(nums, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int[] z = new int[20000001];
//        int[] f = new int[200001];
//        f[0] = 1;

        z[20000] = 1;
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int target = sum - k;
            res += z[target + 20000];

//            if (target > 0) {
//            }else {
//                res += f[-target];
//            }
            z[sum + 20000]++;

//            if (sum > 0) {
//                z[sum+20000] += 1;
//            }else {
//                f[-sum] += 1;
//            }
//            Out.println( sum + "\t " + target + "\t " + res + "\t " + num);
        }

        return res;
    }

    /**
     * 使用hash表进行优化
     */
    public int subarraySum1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
//            Out.println(map);
            sum += nums[i];

            int target = sum - k;

            if (map.containsKey(target)) {
                res += map.get(target);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return res;
    }

    /**
     * 因为数组长度已知，所以暴力循环按道理不会越界
     */
    public int subarraySum2(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        int res = 0;

        for (int i = 1; i < count.length; i++) {
            count[i] = nums[i - 1] + count[i - 1];

            for (int j = 0; j < i; j++) {
                if (count[i] - count[j] == k) {
                    res++;

//                    Out.println(i + "\t " + j);
                }
            }
        }

        return res;
    }

}
