package com.github.morningwn.t1001_t1500.t1201_t1300.t1201_t1210;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/design-skiplist/">1206. 设计跳表</a>
 *
 * @author morningwn
 * @create in 2022/7/26 9:46
 */
public class T1206 {

    @Test
    public void test() {
        Skiplist skiplist = new Skiplist();
        skiplist.add(3);
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(1);

        Out.println(skiplist.search(2));
        Out.println(skiplist.toString());
    }

    class Skiplist {
        private static final int MAX_LEVEL = 16;
        SkipNode header;
        private final Random random;
        private int levelCount;

        public Skiplist() {
            header = new SkipNode();
            random = new Random();
            levelCount = 0;
        }

        public boolean search(int target) {
            SkipNode node = header;
            for (int i = levelCount; i > -1; i--) {
                SkipNode t = node.get(i);
                if (t != null && t.val == target) {
                    return true;
                }
                while (t != null && t.val < target) {
                    Out.println(node);
                    node = t;
                }
            }

            return false;
        }

        public void add(int num) {
            int level = random.nextInt(MAX_LEVEL);
            SkipNode node = new SkipNode(num, level);
            SkipNode tmp = header;
            for (int i = 0; i <= level; i++) {
                while (tmp.get(i) != null && tmp.get(i).val < num) {
                    tmp = tmp.get(i);
                }
                SkipNode next = tmp.nodes[i];
                tmp.nodes[i] = node;
                node.nodes[i] = next;
            }
            levelCount = Math.max(levelCount, level);
        }

        public boolean erase(int num) {
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < levelCount; i++) {
                sb.append("level: ");
                sb.append(i);
                sb.append("\t");

                SkipNode tmp = header;
                while (tmp.get(i) != null) {
                    sb.append(tmp.get(i).val);
                    sb.append(", ");
                    tmp = tmp.get(i);
                }
                sb.append("\n");
            }

            return sb.toString();
        }

        class SkipNode {
            int val;
            int count;
            int level;
            SkipNode[] nodes;

            public SkipNode() {
                this.nodes = new SkipNode[MAX_LEVEL];
            }

            public SkipNode(int val, int level) {
                this.val = val;
                this.level = level;
                this.count = 0;
                this.nodes = new SkipNode[MAX_LEVEL];
            }

            public SkipNode get(int level) {
                return nodes[level];
            }

            @Override
            public String toString() {
                return "SkipNode{" +
                        "val=" + val +
                        ", count=" + count +
                        ", level=" + level + "}";
            }
        }
    }
}
