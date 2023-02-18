package com.github.morningwn.t1001_t1500.t1201_t1300.t1241_t1250;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/count-number-of-nice-subarrays/">1248. 统计「优美子数组」</a>
 *
 * @author morningwn
 * @date Created in 2020/4/21 15:30
 */
public class T1248 {

    @Test
    public void test() {

        //2
//        int k = 3;
//        int[] nums = { 1,1,2,1,1 };

        //0
//        int k = 1;
//        int[] nums = { 2,4,6 };
        //16
        int k = 2;
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        Out.println(numberOfSubarrays(nums, k));
        Out.println(numberOfSubarrays1(nums, k));

    }

    /**
     * 双指针法，使用两个指针分别指向子数组首尾奇数的位置
     *
     * @param nums 输入的数组
     * @param k    子数组中奇数的个数
     * @return 所有子数组的个数
     */
    public int numberOfSubarrays(int[] nums, int k) {

        return 0;
    }

    /**
     * 大佬的最优解
     *
     * @param nums 输入的数组
     * @param k    子数组中奇数的个数
     * @return 所有子数组的个数
     */
    public int numberOfSubarrays0(int[] nums, int k) {
        int[] times = new int[nums.length + 1];
        int count = 0;
        int res = 0;

        times[0] = 1;
        for (int num : nums) {
            count += num & 1;
            times[count]++;
            if (count >= k) {
                res += times[count - k];
            }
        }
        return res;
    }

    /**
     * 使用队列将每两个奇数之间的偶数个数存储起来，计算得到结果
     *
     * @param nums 输入的数组
     * @param k    子数组中奇数的个数
     * @return 所有子数组的个数
     */
    public int numberOfSubarrays1(int[] nums, int k) {

        //用于存储每两个奇数之间的偶数数目的队列，每个值=(实际值+1)
        Queue<Integer> queue = new LinkedList<Integer>();

        //计数，判断nums中有没有k个奇数
        int count = 0;
        //结果
        int res = 0;
        //计算指针i之前的最后一个奇数到i之间有多少偶数
        int times = 1;

        for (int num : nums) {

            //判断当前的数是奇数还是偶数
            //如果为偶数就将times加1，奇数进入下一步判断
            if (num % 2 != 0) {
                //判断当前出现的奇数是否已经有k个了
                //如有就计算这k个奇数可以被分成多少个字数组，结果=两端的偶数个数加一的乘积
                //没有就将count加1
                if (count == k) {
                    res += queue.poll() * times;
                } else {
                    count++;
                }
                //将这个奇数到上个奇数之间的偶数个数存入队列，并将times置为1
                queue.offer(times);
                times = 1;
            } else {
                times++;
            }

//            Out.println( queue + "\t times:" + times + "\t i:" + i + "\t res:" + res + "\t count:" + count );
        }

        //计算最后一次结果，如果有的话
        if (count == k) {
            res += queue.poll() * times;
        }
        return res;
    }

}
