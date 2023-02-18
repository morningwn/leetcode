package com.github.morningwn.t0501_t1000.t0901_t1000.t0941_t0950;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;


public class T0950 {
    @Test
    public void test() {

//        int[] deck = { 17,13,11,2,3,5,7 };
//        int[] deck = { 1,2,3,4,5 };    //[1,5,2,4,3]
//        int[] deck = { 1,2,3,4 };     //[1,3,2,4]
        int[] deck = {1, 2, 3, 4, 5, 6, 7};

        for (int i : deckRevealedIncreasing(deck)) {
            Out.print(i + "\t");
        }
    }

    public int[] deckRevealedIncreasing(int[] deck) {

        if (deck.length < 3) {
            return deck;
        }
        //排序
        deck = BubbleSorting(deck);
//      for ( int i :  deck )
//          Out.print( i +"\t");
//      Out.println();

        //暂存分割后的数组
        ArrayList<int[]> heap = new ArrayList<>();

        //用于存储切割后的字串长度
        double length = deck.length;

        //指针，指向deck中的当前数字
        int count = 0;

        //用来把deck给切割成一个一个的字串，依次减半，到2停止
        while (count < deck.length) {

            length = deck.length - count;

            //判断是不是到2了，没有就除有就停止
            if (length > 2) {
                length = Math.ceil(length / 2);
            } else {
                length = Math.ceil(length);
            }

            //初始化
            int[] temp = new int[(int) length];
            for (int i = 0; i < length; i++) {
                temp[i] = deck[count++];
            }

            //将切好的数组放list中
            heap.add(temp);

        }

        //将切好的数组合并为最终结果
        while (heap.size() > 1) {

            int[] nums1 = heap.get(heap.size() - 2);
            int[] nums2 = heap.get(heap.size() - 1);

            int[] temp = new int[nums1.length + nums2.length];

            //根据将要合并的两个数组长度是否一样，进行下一步
            //不一样
            if (nums2.length != nums1.length) {

                for (int i = 0, j = 0; i + j < temp.length; ) {
                    temp[i + j] = nums1[i++];
                    if (i + j < temp.length) {
                        if (j > 0) {
                            temp[i + j] = nums2[j - 1];
                        } else {
                            temp[i + j] = nums2[nums2.length == 1 ? 0 : nums2.length - 1];
                        }
                    }

                    j++;
                }

                //一样
            } else {
                for (int i = 0, j = 0; i + j < temp.length; ) {
                    temp[i + j] = nums1[i++];
                    if (j < nums2.length) {
                        temp[i + j] = nums2[j++];
                    }
                }
            }

            //移除已经合并的数组，并将合并后的结果存在list中
            heap.remove(heap.size() - 1);
            heap.remove(heap.size() - 1);
            heap.add(temp);
        }

        return heap.get(0);
    }

    //冒泡排序
    public int[] BubbleSorting(int nums[]) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

}