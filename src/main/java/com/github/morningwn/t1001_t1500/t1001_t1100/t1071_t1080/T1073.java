package com.github.morningwn.t1001_t1500.t1001_t1100.t1071_t1080;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/adding-two-negabinary-numbers/">1073. 负二进制数相加</a>
 *
 * @author morningwn
 * @create in
 */
public class T1073 {

    @Test
    public void test() {

//        //1	 1	 0	 0
//        int[] arr1 = {1, 0 };
//        int[] arr2 = {  1, 0 };
//        //0
//        int[] arr1 = { 0 };
//        int[] arr2 = { 0 };
//        //1 0 1
//        int[] arr1 = { 0 };
//        int[] arr2 = { 1, 0, 1};
//        //0
//        int[] arr1 = { 1, 1, 1, 1 };
//        int[] arr2 = {1 ,0, 1 };
//        //1	 0	 0	 0	 0
//        int[] arr1 = {1, 1, 1, 1, 1 };
//        int[] arr2 = {1 ,0, 1 };
//        //1	 1 0
//        int[] arr1 = {1 };
//        int[] arr2 = {1 };
//        //1	 1	 0	 0	 0
//        int[] arr1 = { 1, 0, 1 };
//        int[] arr2 = {1, 1, 1 };
        //1	 1	 1	 1	 0
        int[] arr1 = {1, 0, 1};
        int[] arr2 = {1, 0, 1};

        for (int i : addNegabinary(arr1, arr2)) {
            Out.print(i + "\t ");
        }
    }

    public int[] addNegabinary(int[] arr1, int[] arr2) {

        int len = Math.max(arr1.length, arr2.length) + 2;        //结果最长的长度
        int[] res = new int[len];        //结果集
        int i = arr1.length - 1;           //标记在arr1计算到了那个位置
        int j = arr2.length - 1;          //标记在arr2计算到了那个位置
        int count = len - 1;              //标记在结果中计算到了那个位置

        //当arr1和arr2均有数时
        while (i >= 0 && j >= 0) {

            //存储这一位的计算结果
            int tmp = res[count] + arr1[i] + arr2[j];

            //当计算结果大于等于2的时候需要进位
            if (tmp >= 2) {

                //计算并进位
                res[count] = tmp % 2;
                res[count - 1] += tmp / 2;
                res[count - 2] += tmp / 2;
            } else {
                res[count] = tmp;
            }
            i--;
            j--;
            count--;
        }
        //当只有arr1有数时
        while (i >= 0) {
            int tmp = res[count] + arr1[i];
            if (tmp >= 2) {
                res[count] = tmp % 2;
                res[count - 1] += tmp / 2;
                res[count - 2] += tmp / 2;
            } else {
                res[count] = tmp;
            }
            i--;
            count--;

        }

        //当只有arr2有数时
        while (j >= 0) {
            int tmp = res[count] + arr2[j];
            if (tmp >= 2) {
                res[count] = tmp % 2;
                res[count - 1] += tmp / 2;
                res[count - 2] += tmp / 2;
            } else {
                res[count] = tmp;
            }
            j--;
            count--;

        }

        //对最后的前两位进行处理，因为倒数第二位存在继续向前进位的可能
        res[count - 1] -= (res[count] / 2);
        res[count] = res[count] % 2;

        //从前往后查找首个不为零的数
        int k = 0;
        while (k < len - 1 && res[k] == 0) {
            k++;
        }
        //对数组进行切割，切除为零的前缀，返回结果
        return Arrays.copyOfRange(res, k, len);
    }

}
