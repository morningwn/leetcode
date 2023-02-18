package com.github.morningwn.t0001_t0500.t0101_t0200.t0131_t0140;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date 2020/11/18 9:03
 */
public class T0134 {

    @Test
    public void test() {
//        int[] gas = {1, 2, 3, 4, 5, 2, 1, 2, 3, 4, 5, 6, 7, 2, 2};
//        int[] cost = {3, 4, 5, 1, 2, 6, 5, 3, 1, 2, 3, 5, 6, 5, 3};
        int[] gas = {2, 3, 4, 5, 4, 3, 2, 1, 2, 4, 5, 7, 6, 5};
        int[] cost = {3, 4, 3, 4, 5, 7, 8, 6, 4, 2, 3, 5, 6, 7};

        Out.println(canCompleteCircuit(gas, cost));
    }

    /**
     * 最优解，一次遍历
     * 因为这个是一个环，所以如果能遍历到达数组终点，那就必定是解
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //记录走完后总的剩余，如果存在解的话那就必大于零
        int totalGas = 0;
        //记录当前位置往后的剩余，如果小于零就重新进行计算，
        int curGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];

            //重新进行计算
            if (curGas < 0) {
                curGas = 0;
                start = i + 1;
            }
        }

        return totalGas >= 0 ? start : -1;

    }
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int len = gas.length;
//
//        for (int i = 0; i < len; i++) {
//            int last = 0;
//            for (int j = i+len; j <= 2*len+i && last >= 0; j++) {
//                last += gas[j%len] - cost[j%len];
//                Out.println("i:" + i + "\t j:" + j + "\t j%len:" + (j%len) + "\t gas:" +gas[j%len]+"\t cost:" + cost[j%len] +"\t last:" + last);
//            }
//            if (last >= 0) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
}
