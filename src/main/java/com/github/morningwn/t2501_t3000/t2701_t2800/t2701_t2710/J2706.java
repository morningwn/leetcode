package com.github.morningwn.t2501_t3000.t2701_t2800.t2701_t2710;

import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.cn/problems/buy-two-chocolates/">2706. 购买两块巧克力</a>
 * <ul>
 * <li>{@link Difficulty#Easy}</li>
 * <li>{@link Topic#Array}</li>
 * <li>{@link Topic#Sorting}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-12-29 10:27:42
 */
public class J2706 {

    @Test
    public void test() {

    }

    public int buyChoco(int[] prices, int money) {
        int[] priceCount = new int[101];
        for (int price : prices) {
            priceCount[price]++;
        }
        int originMoney = money;
        int flag = 2;
        for (int i = 1; i < priceCount.length; i++) {
            if (i > money) {
                return originMoney;
            } else {
                if (priceCount[i] == 1) {
                    money -= i;
                    flag--;
                } else if (priceCount[i] >= 2) {
                    money -= i * flag;
                    flag = 0;
                }
                if (money < 0) {
                    return originMoney;
                }
                if (flag == 0) {
                    return money;
                }
            }
        }
        return originMoney;
    }
}
