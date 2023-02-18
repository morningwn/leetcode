package com.github.morningwn.t0501_t1000.t0601_t0700.t0671_t0680;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/implement-magic-dictionary/">676. 实现一个魔法字典</a>
 *
 * @author morningwn
 * @create in 2022/7/11 17:08
 */
public class T0676 {

    @Test
    public void test() {

    }

    class MagicDictionary {
        private final TrieNode root;

        public MagicDictionary() {
            root = new TrieNode();
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                insert(s);
            }
        }

        private void insert(String word) {

            char[] chars = word.toCharArray();
            TrieNode cur = root;
            for (char w : chars) {
                if (cur.children[w - 'a'] == null) {
                    cur.children[w - 'a'] = new TrieNode(w);
                }
                cur = cur.children[w - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String searchWord) {
            char[] chars = searchWord.toCharArray();
            return searchOne(root, chars, 0, false);
        }

        private boolean searchOne(TrieNode node, char[] chars, int index, boolean flag) {
            if (chars.length == index + 1) {
                // 必须有一个差异
                return node.isWord && !flag;
            }

            boolean res = false;
            if (!flag) {
                for (TrieNode child : node.children) {
                    if (child != null && child.val != chars[index]) {
                        res |= searchOne(child, chars, index + 1, true);
                    }
                }
                if (node.children[chars[index] - 'a'] != null) {
                    res |= searchOne(node.children[chars[index] - 'a'], chars, index + 1, false);
                }
            } else {
                if (node.children[chars[index] - 'a'] == null) {
                    return false;
                } else {
                    res |= searchOne(node.children[chars[index] - 'a'], chars, index + 1, true);
                }
            }
            return res;
        }
    }

    class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            this(' ');
        }

        public TrieNode(char val) {
            this.val = val;
            children = new TrieNode[26];
            isWord = false;
        }
    }
}
