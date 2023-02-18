package com.github.morningwn.t1001_t1500.t1201_t1300.t1281_t1290;

import com.github.morningwn.prefab.ListNode;
import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/">1290. 二进制链表转整数</a>
 *
 * @author moringwn
 * @date
 */
public class T1290 {

    @Test
    public void test() {

//        int input[] = {1,0,1};              //5
//        int input[] = {0, 0};               //0
        int[] input = {1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};               //18880
//        int input[] = {1};               //1

        ListNode root = new ListNode(input[0]);
        ListNode node = root;
        for (int i = 1; i < input.length; i++) {
            ListNode tmp = new ListNode(input[i]);
            node.next = tmp;
            node = node.next;
        }

        Out.println(getDecimalValue(root));
    }

    public int getDecimalValue(ListNode head) {

        //方案1
/*        String result = "";
        ListNode next = head;
        while ( next != null ){
            result += next.val;
            next = next.next;
        }

//        Out.println( result );
//        Out.println( Integer.valueOf(result,2));
        return Integer.valueOf(result,2);*/

        //方案2
        int result = 0;
        ListNode node = head;

        while (node != null) {
            result *= 2;
            result += node.val;
            node = node.next;
        }

        return result;
    }
}


