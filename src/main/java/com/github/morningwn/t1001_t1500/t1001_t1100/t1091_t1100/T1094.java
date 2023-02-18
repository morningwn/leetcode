package com.github.morningwn.t1001_t1500.t1001_t1100.t1091_t1100;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class T1094 {

    @Test
    public void test() {
//        int[][] trips = {{2,1,5},{3,3,7}};      //false     4
//        int[][] trips = {{3,2,7},{3,7,9},{8,3,9}};      //true      11
//        int[][] trips = {{2,1,5},{3,5,7}};      //true      3
        int[][] trips = {{8, 2, 3}, {4, 1, 3}, {1, 3, 6}, {8, 4, 6}, {4, 4, 8}};      //false 12
//        int[][] trips = {{7,5,6},{6,7,8},{10,1,6}};       //false 16
        Out.println(carPooling(trips, 12));
    }

    //大佬的代码
    public boolean carPooling(int[][] trips, int capacity) {

        //存储每一站上下车的信息
        //正数代表上车，负数代表下车
        int[] count = new int[1001];

        //遍历trips，将上下车信息存储在count里面
        for (int[] trip : trips) {
            count[trip[1]] += trip[0];
            count[trip[2]] -= trip[0];
        }

        //判断第一次上车的人数是否超过了，座位数
        if (count[0] > capacity) {
            return false;
        }

        //遍历count数组，将之前所有的上下车信息全部累加起来
        //判断是否超过了座位数
        for (int i = 1; i < 1001; i++) {
            count[i] += count[i - 1];
            if (capacity < count[i]) {
                return false;
            }
        }

        return true;
    }

    //本菜鸡的代码
    public boolean carPooling1(int[][] trips, int capacity) {

        //记录每一次上下车的信息
        Map<Integer, Integer> getOn = new HashMap<Integer, Integer>();
        Map<Integer, Integer> getOff = new HashMap<Integer, Integer>();

        //将上下车的信息存储在哈希表中
        for (int[] i : trips) {

            int tmp = i[0] + getOn.getOrDefault(i[1], 0);
            getOn.put(i[1], tmp);
            tmp = i[0] + getOff.getOrDefault(i[2], 0);

            //如果某站下车的人数超过了座位数，显然完不成任务
            if (tmp > capacity) {
                return false;
            } else {
                getOff.put(i[2], tmp);
            }
        }

        //遍历所有的哈希表
        for (int i = 0; i <= 1000 && getOn.size() > 0; i++) {

            //将下车的座位释放，上车的座位减去
            capacity += getOff.getOrDefault(i, 0);
            capacity -= getOn.getOrDefault(i, 0);

            //将已经处理过的上车信息移除
            getOn.remove(i);

            //如果座位不够，返回false
            if (capacity < 0) {
                return false;
            }
        }

        return true;
    }

}
