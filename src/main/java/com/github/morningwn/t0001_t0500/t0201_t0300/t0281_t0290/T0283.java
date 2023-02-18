package com.github.morningwn.t0001_t0500.t0201_t0300.t0281_t0290;

/**
 * 移动零
 *
 * @author morningwn
 * @date 2020/11/19 9:46
 */
public class T0283 {

    /**
     * 双指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = 0;
                nums[left++] = tmp;
            }
        }
    }
//    /**
//     *因为后面的全都是0，所以可以先移动，最后统一赋值
//     * @param nums
//     */
//    public void moveZeroes(int[] nums) {
//        if (nums == null) { return; }
//        int index = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[index++] = nums[i];
//            }
//        }
//
//        for (int i = index; i < nums.length; i++) {
//            nums[i] = 0;
//        }
//    }
}
