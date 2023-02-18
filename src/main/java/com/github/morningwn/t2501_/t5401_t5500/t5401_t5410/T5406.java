package com.github.morningwn.t2501_.t5401_t5500.t5401_t5410;

/**
 * @author morningwn
 * @description: 收集树上所有苹果的最少时间
 * @date Created in 2020/5/10 11:42
 * @version: 1.0
 */
public class T5406 {
    public T5406() {

    }

//    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
//        MyTreeNode root = new MyTreeNode(0);
//        Stack<MyTreeNode> stack = new Stack<>();
//        stack.push(root);
//        int index = 1;
//
//        while (!stack.isEmpty()) {
//            MyTreeNode tmp  = stack.peek();
//            if (tmp.id == edges[index][0]) {
//                stack.pop();
//                tmp.left = new MyTreeNode(edges[index][1]);
//                stack.push(tmp.left);
//                index++;
//            }
//            if (tmp.id == edges[index][0]) {
//                tmp.right = new MyTreeNode(edges[0][1]);
//                stack.push(tmp.right);
//                index++;
//            }
//        }
//    }

    public void test() {
        new T5406();
    }

    class MyTreeNode {
        boolean hasApple;
        boolean passing;
        MyTreeNode left;
        MyTreeNode right;
        int distance;
        int id;

        public MyTreeNode(int id) {
            this.id = id;
        }
    }
}
