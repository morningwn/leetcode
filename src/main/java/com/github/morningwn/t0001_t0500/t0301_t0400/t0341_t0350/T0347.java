package com.github.morningwn.t0001_t0500.t0301_t0400.t0341_t0350;

import com.github.morningwn.prefab.Out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class T0347 {

    public void test() {

//        int[] nums = {4,1,-1,2,-1,2,3};         //[-1,2]
//        int[] nums = {1,1,1,2,2,3};             //[1, 2]
//        int[] nums = {1};                          //[1]
//        int[] nums = {5,2,5,3,5,3,1,1,3};           //[5,3]
//        int[] nums = {5,3,1,1,1,3,5,73,1};          //[1, 5, 3]
//        int[] nums = { -1, -1 };

//        int[]  nums = new int[50];
//        List<Integer> list = new ArrayList<>();
//
//        for ( int i = 0; i < 50; i++ ){
//            int tmp = (int)(Math.random()*10);
//            nums[i] = tmp;
//            list.add( tmp );
//        }

        //8,0， 9， 6， 3
        int[] nums = {2, 3, 0, 8, 9, 9, 7, 3, 9, 0, 6, 8, 3, 9, 8, 0, 1, 0, 0, 2, 3, 0, 0, 3, 6, 8, 6, 4, 8, 3, 8, 9, 1, 4, 8, 2, 9, 8, 0, 5, 7, 1, 9, 8, 6, 7, 7, 6, 6, 0};
//        Out.println(list);
        Out.println(topKFrequent(nums, 5));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>(k);
        Map<Integer, Integer> dir = new HashMap<>();

        for (int num : nums) {
            int count = dir.getOrDefault(num, 0) + 1;
            dir.put(num, count);

            //num已经在结果中，仅对结果进行排序
            if (res.contains(num)) {

                //结果集中有两个及以上的数才需要进行排序
                if (res.size() > 1) {

                    //先存下索引
                    int index = res.indexOf(num);
                    //将这个数从结果中删除
                    res.remove(index);
                    //从原数的位置开始，向前查询，直到出现的次数不比他小
                    while (index > 0 && dir.get(res.get(index - 1)) < count) {
                        index--;
                    }
                    //将其添加在结果集中相应的位置
                    res.add(index, num);
                }
            } else {

                //如果长度为零，无需进行排序后插入，直接插入就行
                if (res.size() == 0) {
                    res.add(num);
                } else {

                    //同上
                    int index = res.size();
                    while (index > 0 && dir.get(res.get(index - 1)) < count) {
                        index--;
                    }

                    res.add(index, num);
                }

                //添加进去，长度超过了就将其删除
                if (res.size() > k) {
                    res.remove(k);
                }
            }
        }

        return res;
    }

}
