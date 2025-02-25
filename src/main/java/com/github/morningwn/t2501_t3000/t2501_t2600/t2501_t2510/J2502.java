package com.github.morningwn.t2501_t3000.t2501_t2600.t2501_t2510;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/design-memory-allocator">2502. 设计内存分配器</a>
 *
 * @author morningwn
 * @date Created in 2025/2/25 10:36
 */
public class J2502 {

    @Test
    public void test() {
        case1();
        case2();
    }

    private void case1() {
        Allocator allocator = new Allocator(10);
        Assert.assertEquals(0, allocator.allocate(1, 1));
        Assert.assertEquals(1, allocator.allocate(1, 2));
        Assert.assertEquals(2, allocator.allocate(1, 3));
        Assert.assertEquals(1, allocator.freeMemory(2));
        Assert.assertEquals(3, allocator.allocate(3, 4));
        Assert.assertEquals(1, allocator.allocate(1, 1));
        Assert.assertEquals(6, allocator.allocate(1, 1));
        Assert.assertEquals(3, allocator.freeMemory(1));
        Assert.assertEquals(-1, allocator.allocate(10, 2));
        Assert.assertEquals(0, allocator.freeMemory(7));
    }

    private void case2() {
        Allocator allocator = new Allocator(5);
        Assert.assertEquals(0, allocator.freeMemory(4));
        Assert.assertEquals(-1, allocator.allocate(9, 5));
        Assert.assertEquals(0, allocator.allocate(5, 8));
        Assert.assertEquals(-1, allocator.allocate(4, 8));
        Assert.assertEquals(-1, allocator.allocate(3, 2));
        Assert.assertEquals(0, allocator.freeMemory(6));
        Assert.assertEquals(-1, allocator.allocate(9, 9));
        Assert.assertEquals(0, allocator.freeMemory(6));
    }

    class Allocator {

        class Node {
            private Node pre;
            private Node next;
            private int index;
            private int size;
            private int mID;

            Node(Node pre, Node next, int index, int size, int mid) {
                this.pre = pre;
                this.next = next;
                this.index = index;
                this.size = size;
                this.mID = mid;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "index=" + index +
                        ", mID=" + mID +
                        ", next=" + next +
                        '}';
            }
        }

        private int freeSize;
        private Node header;
        private Map<Integer, List<Node>> map;

        public Allocator(int n) {
            freeSize = n;
            map = new HashMap<>();
            header = new Node(null, null, 0, 0, 0);
            header.next = new Node(header, null, n, 0, 0);
            header.next.pre = header;
        }

        public int allocate(int size, int mID) {
            if (freeSize < size) {
                return -1;
            }
            Node node = header;
            while (node.next != null) {
                if (node.next.index - node.index - node.size >= size) {
                    break;
                }
                node = node.next;
            }
            if (node.next == null) {
                return -1;
            }
            Node tmp = new Node(node, node.next, node.index + node.size, size, mID);
            Node tmpNext = node.next;
            node.next = tmp;
            tmpNext.pre = tmp;
            freeSize -= size;
            map.computeIfAbsent(mID, k -> new ArrayList<>()).add(tmp);
            return tmp.index;
        }

        public int freeMemory(int mID) {
            List<Node> nodeList = map.get(mID);
            if (nodeList == null || nodeList.isEmpty()) {
                return 0;
            }
            int totalSize = 0;
            for (Node node : nodeList) {
                if (node.pre != null) {
                    node.pre.next = node.next;
                }
                if (node.next != null) {
                    node.next.pre = node.pre;
                }
                node.next = null;
                node.pre = null;
                totalSize += node.size;
                freeSize += node.size;
            }
            map.remove(mID);
            return totalSize;
        }
    }

}