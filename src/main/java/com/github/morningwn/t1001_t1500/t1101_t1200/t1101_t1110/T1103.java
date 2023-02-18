package com.github.morningwn.t1001_t1500.t1101_t1200.t1101_t1110;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/distribute-candies-to-people/">1103. 分糖果 II</a>
 *
 * @author moringwn
 * @create in
 */
public class T1103 {

    @Test
    public void test() {
        for (int i : distributeCandies(2, 3)) {
            Out.print(i + "\t ");
        }

        Out.println();

        for (int i : distributeCandies1(2, 3)) {
            Out.print(i + "\t ");
        }
    }

    public int[] distributeCandies(int candies, int num_people) {

        //存储结果
        int[] res = new int[num_people];

        //目前用来存储输入的糖果数量，用于下一步的计算
        int tmp = candies;

        //存储可以发几轮糖果
        int times = 0;

        //计算最多可以发几轮糖果，不够一轮的话，仍然算上
        //原理就是等差数列的前n项和
        while (tmp > 0) {
            times++;
            tmp = tmp - ((((times - 1) * num_people + 1) + times * num_people) * num_people / 2);
        }

        //因为不知道最后一轮够不够发，所以要减去,等下单独算
        times--;

        //将除最后一轮的糖果，一次性全部发完
        for (int i = 1; i <= num_people && times > 0; i++) {
            //计算本轮要发的糖果
            tmp = ((2 * i + (times - 1) * num_people) * (times)) / 2;
            //赋值
            res[i - 1] = tmp;
            //减去发的糖果
            candies -= tmp;
        }

        //这个时候tmp代表倒数第二轮给最后一个小朋友发的糖果数
        tmp = num_people * times;

        //单独给最后一轮发糖果
        while (candies > 0) {

            //给第tmp个人发tmp个糖，当tmp超过人数的时候，取余就行了
            //后面的表达式用来判断剩下的糖是否够发
            res[tmp % num_people] = res[tmp % num_people] + (candies > tmp + 1 ? tmp + 1 : candies);
            //减去这次发的糖，然后将i加一，进入下一轮
            candies -= (tmp + 1);
            tmp++;
        }

        return res;
    }

    //简单的算法，暴力循环
    public int[] distributeCandies1(int candies, int num_people) {

        //初始化存结果的数组
        int[] res = new int[num_people];

        //因为发给第一个人和给没个人发多少个糖果是同步增长的，一个标记就行了
        int i = 0;

        while (candies > 0) {

            //给第i个人发i个糖，当i超过人数的时候，取余就行了
            //后面的表达式用来判断剩下的糖是否够发
            res[i % num_people] = res[i % num_people] + (candies > i + 1 ? i + 1 : candies);

            //减去这次发的糖，然后将i加一，进入下一轮
            candies -= (i + 1);
            i++;
        }

        return res;
    }
}
