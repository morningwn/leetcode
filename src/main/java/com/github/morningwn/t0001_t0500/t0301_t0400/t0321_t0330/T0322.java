package com.github.morningwn.t0001_t0500.t0301_t0400.t0321_t0330;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

public class T0322 {

    @Test
    public void test() {

//        int[] coins = {1, 2, 5};        //11      3     [5, 5, 1]
        int[] coins = {2};                 //1      -1

//        int[] coins = {478,487,16,338};     //1990 15
        //83, 186, 408, 419
//        int[] coins = {186,419,83,408};        //6249       20

//        int[] coins = { 19, 9, 7, 2, 1 };        //6249       20
        Out.println(coinChange(coins, 11));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] counts = new int[amount + 1];

        int index = 0;
        for (int i = 1; i <= amount; i++) {
            if (i == coins[index]) {
                counts[i] = 1;
            } else if (i - coins[index] >= 0) {
                int mul = 1;
                counts[i] = counts[i - coins[index]] + 1;
                while (i - coins[index] * mul >= 0) {
                    if (counts[i - coins[index] * mul] != -1) {
                        counts[i] = Math.min(counts[i - coins[index] * mul] + mul, counts[i]);
                    }
                    mul++;
                }
            } else {
                counts[i] = -1;
                if (i == amount) {
                    return -1;
                }
            }
            if (index < coins.length - 1 && coins[index] < i) {
                index++;
            }
            Out.println(counts[i] + "\t " + i);
        }

        return counts[amount];
    }

}
