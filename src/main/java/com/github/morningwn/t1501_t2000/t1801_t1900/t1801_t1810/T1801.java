package com.github.morningwn.t1501_t2000.t1801_t1900.t1801_t1810;

import com.github.morningwn.prefab.FormatInput;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/number-of-orders-in-the-backlog/">1801. 积压订单中的订单总数</a>
 *
 * @author morningwn
 * @create in 2023/1/2 13:46
 */
public class T1801 {

    @Test
    public void test() {
//        int[][] orders = FormatInput.stringTo2Array("[[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]", 3);
//        int[][] orders = FormatInput.stringTo2Array("[[10,5,0],[15,2,1],[25,1,1],[30,4,0]]", 3);
//        int[][] orders = FormatInput.stringTo2Array("[[10,5,0],[15,2,1],[25,1,1],[30,4,0],[15,2,1],[25,1,1],[30,4,0]]", 3); // 7
//        int[][] orders = FormatInput.stringTo2Array("[[10,5,0],[15,22,1],[15,12,1],[36,23,0],[1,22,1],[25,12,1],[30,54,0]]", 3); //14
        int[][] orders = FormatInput.stringTo2Array("[[256747981,42552473,0],[433221795,24553625,1],[39058615,62787129,1],[720166430,35659558,1],[512646682,41495376,0],[734056250,71045086,1],[805803683,2917862,0],[666944821,78766733,1]]", 3); //185846420

        int numberOfBacklogOrders = getNumberOfBacklogOrders(orders);
        Out.println(numberOfBacklogOrders);
    }

    /**
     * [pricei, amounti, orderTypei]
     *
     * @param orders
     * @return
     */
    public int getNumberOfBacklogOrders(int[][] orders) {
        // 最高
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        // 最低
        PriorityQueue<int[]> sellQueue = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        for (int[] order : orders) {
            // sell
            if (order[2] == 1) {
                int amount = order[1];
                while (!buyQueue.isEmpty() && buyQueue.peek()[0] >= order[0]) {
                    if (buyQueue.peek()[1] > amount) {
                        buyQueue.peek()[1] = buyQueue.peek()[1] - amount;
                        amount = 0;
                        break;
                    } else if (buyQueue.peek()[1] == amount) {
                        buyQueue.poll()[1] = 0;
                        amount = 0;
                        break;
                    } else {
                        int[] poll = buyQueue.poll();
                        amount -= poll[1];
                        poll[1] = 0;
                    }
                }
                order[1] = amount;
                if (amount > 0) {
                    sellQueue.offer(order);
                }
            } else {
                // buy
                int amount = order[1];
                while (!sellQueue.isEmpty() && sellQueue.peek()[0] <= order[0]) {
                    if (sellQueue.peek()[1] > amount) {
                        sellQueue.peek()[1] = sellQueue.peek()[1] - amount;
                        amount = 0;
                        break;
                    } else if (sellQueue.peek()[1] == amount) {
                        sellQueue.poll()[1] = 0;
                        amount = 0;
                        break;
                    } else {
                        int[] poll = sellQueue.poll();
                        amount -= poll[1];
                        poll[1] = 0;
                    }
                }
                order[1] = amount;
                if (amount > 0) {
                    buyQueue.offer(order);
                }
            }
        }

        Out.println(buyQueue);
        Out.println(sellQueue);
        int totalAmount = 0;
        final int MOD = 1000000007;
        for (int[] order : orders) {
            totalAmount += order[1] % MOD;
            totalAmount = totalAmount % MOD;
        }
        return totalAmount;
    }

}
