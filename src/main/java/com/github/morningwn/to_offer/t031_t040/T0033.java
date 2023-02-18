package com.github.morningwn.to_offer.t031_t040;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/7/9 13:08
 */
public class T0033 {

    @Test
    public void test() {
        int[] postOrder = {1, 2, 5, 10, 6, 9, 4, 3};
        Out.println(verifyPostorder(postOrder));
    }

    /**
     * @author morningwn
     * @date 2020/7/10 10:36
     * @description: 递归
     * @param: postorder
     * @return: boolean
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        } else {
            return helper(0, postorder.length - 1, postorder);
        }
    }

    /**
     * @author morningwn
     * @date 2020/7/10 10:36
     * @description: 若存在唯一的一个中间节点使得前面的都比根节点大，后面的都小，就递归进入下次循环，否则返回false
     * @param: start
     * @param: end
     * @param: postOrder
     * @return: boolean
     */
    public boolean helper(int start, int end, int[] postOrder) {
        if (start >= end) {
            return true;
        }
        int middle = start;

        while (postOrder[middle] < postOrder[end]) {
            middle++;
        }
        Out.println("start:" + start + "\t middle:" + middle + "\t end" + end);


        for (int i = middle; i < end; i++) {
            if (postOrder[i] < postOrder[end]) {
                return false;
            }
        }

        return helper(start, middle - 1, postOrder) && helper(middle, end - 1, postOrder);
    }

}
