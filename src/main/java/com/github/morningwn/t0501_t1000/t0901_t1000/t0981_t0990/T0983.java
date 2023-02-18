package com.github.morningwn.t0501_t1000.t0901_t1000.t0981_t0990;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/6 11:51
 */
public class T0983 {

    @Test
    public void test() {

//        int[] days = {1};
//        int[] costs = {2,7,15};
//        int[] days = {3,5,6,8,9,10,11,12,13,14,15,16,20,21,23,25,26,27,29,30,33,34,35,36,38,39,40,42,45,46,47,48,49,51,53,54,56,57,58,59,60,61,63,64,67,68,69,70,72,74,77,78,79,80,81,82,83,84,85,88,91,92,93,96};
//        int[] costs = {3,17,57};
//        int[] days = {1,4,6,7,8,20};
//        int[] costs = {7,2,15};
//        int[] days = {3,12,17,32,34,37,42,43,50,53,54,55,56,57,59,60,62,63,64,66};
        int[] days = {1, 2, 4, 5, 6, 7, 10, 13, 14, 17, 18, 19, 20, 22, 25, 26, 27, 28, 32, 35, 36, 38, 40, 41, 42, 43, 45, 46, 47, 48, 50, 51, 52, 54, 56, 59, 61, 63, 64, 70, 71, 72, 79, 80, 81, 82, 84, 85, 86, 87, 95, 96, 100, 101, 105, 106, 108, 111, 112, 114, 115, 116, 118, 119, 120, 122, 126, 128, 130, 131, 133, 135, 139, 140, 141, 145, 147, 148, 150, 152, 153, 159, 160, 161, 166, 168, 170, 171, 172, 175, 176, 179, 180, 183, 186, 191, 193, 195, 197, 198, 199, 202, 204, 205, 209, 213, 214, 218, 219, 220, 221, 223, 224, 226, 227, 229, 230, 231, 233, 234, 235, 236, 237, 238, 240, 241, 242, 244, 245, 246, 249, 250, 253, 254, 256, 259, 261, 264, 268, 271, 272, 278, 279, 280, 282, 283, 284, 286, 288, 289, 290, 292, 293, 298, 299, 303, 304, 305, 306, 309, 310, 311, 312, 316, 317, 318, 319, 320, 321, 322, 324, 326, 327, 328, 330, 335, 338, 340, 342, 343, 344, 345, 346, 348, 350, 352, 353, 354, 355, 357, 358, 359, 361, 362, 364};
        int[] costs = {30, 133, 499};
//        int[] days = {3,12,17,  32,34,37,  42,43,50,53,54,55,56,57,59,60,62  ,63,64,66,70,71,73,79,85,87,91,95,99};
//        int[] costs = {3,12,44};
        Out.println(mincostTickets(days, costs));
//        Out.println(mincostTickets1(days, costs));

    }

    /**
     * 非递归算法，动态规划
     *
     * @param days  代表那几天取旅游
     * @param costs 输入不同的时间的票的价格
     * @return 返回总价格的最小值
     */
    public int mincostTickets(int[] days, int[] costs) {

        //记录旅游的最后一天
        int last = days[days.length - 1];

        //记录旅游到当前时间花费金钱的最小值
        int[] count = new int[last + 1];

        //假定需要出去旅游的时候，只买当天的票，将其价格填入数组
        //同时也用来辨别都是那天出去旅游了
        for (int day : days) {
            count[day] = costs[0];
        }

        //从头到尾计算截至每天的花费的最小值
        for (int i = 2; i <= last; i++) {

            //分别计算使用三种不同的方法购买票的花费，取最小值
            int cost1 = count[i - 1] + count[i];
            int cost2 = Integer.MAX_VALUE;
            int cost3 = Integer.MAX_VALUE;
            if (i > 7) {
                cost2 = count[i - 7] + costs[1];
            } else {
                cost2 = costs[1];
            }
            if (i > 30) {
                cost3 = count[i - 30] + costs[2];
            } else {
                cost3 = costs[2];
            }

            count[i] = Math.min(cost1, Math.min(cost2, cost3));

        }

        //返回截至最后一天的花费
        return count[last];

    }

    /**
     * 递归算法，妥妥的超时，但是正确
     *
     * @param days  代表那几天取旅游
     * @param costs 输入不同的时间的票的价格
     * @return 返回总价格的最小值
     */
    public int mincostTickets1(int[] days, int[] costs) {
        return costTicket(days, costs, 0);
    }

    public int costTicket(int[] days, int[] costs, int index) {
        if (index >= days.length) {
            return 0;
        }
        int nextIndex1 = index + 1;
        int nextIndex2 = index + 1;
        int nextIndex3 = index + 1;

        for (int i = 0; i < 6 && nextIndex2 < days.length; i++) {
            if (days[nextIndex2] - days[index] < 7) {
                nextIndex2++;
            } else {
                break;
            }
        }
        for (int i = 0; i < 29 && nextIndex3 < days.length; i++) {
            if (days[nextIndex3] - days[index] < 30) {
                nextIndex3++;
            } else {
                break;
            }
        }
        int cost1 = costs[0] + costTicket(days, costs, nextIndex1);
        int cost2 = costs[1] + costTicket(days, costs, nextIndex2);
        int cost3 = costs[2] + costTicket(days, costs, nextIndex3);

        return Math.min(cost1, Math.min(cost2, cost3));
    }

}
