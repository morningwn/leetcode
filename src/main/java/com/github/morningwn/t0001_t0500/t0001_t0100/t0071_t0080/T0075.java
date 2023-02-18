package com.github.morningwn.t0001_t0500.t0001_t0100.t0071_t0080;

/**
 * 颜色分类
 *
 * @author morningwn
 * @date 2020/10/7  16:21
 */
public class T0075 {

    /**
     * 使用双指针，分别指向分界点，然后相互进行交换操作
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int p01 = 0;
        int p12 = 0;
        //注意进行交换时的顺序
        //当p01,p12为0时有特殊情况，不然任何顺序都可以
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    //先更改靠后的数据
                    //这样如果是指针重叠的时候最后还是会修改为原本的值
                    nums[i] = 2;
                    nums[p01++] = 0;
                    nums[p12++] = 1;
                    break;
                case 1:
                    nums[i] = 2;
                    nums[p12++] = 1;
                    break;
                default:
                    break;
            }
        }
    }

//    /**
//     * 简单的两次遍历，统计数据然后重写数组
//     * @param nums
//     */
//    public void sortColors(int[] nums) {
//        int count0 = 0;
//        int count1 = 0;
//        int count2 = 0;
//
//        for (int num: nums) {
//            switch (num) {
//                case 0:
//                    count0++;
//                    break;
//                case 1:
//                    count1++;
//                    break;
//                case 2:
//                    count2++;
//                    break;
//                default:
//                    break;
//            }
//        }
//
//        for (int i = 0; i < count0; i++) {
//            nums[i] = 0;
//        }
//
//        for (int i = 0; i < count1; i++) {
//            nums[count0+i] = 1;
//        }
//
//        for (int i = 0; i < count2; i++) {
//            nums[count0+count1+i] = 2;
//        }
//    }
}
