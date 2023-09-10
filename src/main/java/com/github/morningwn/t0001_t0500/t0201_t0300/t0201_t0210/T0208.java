package com.github.morningwn.t0001_t0500.t0201_t0300.t0201_t0210;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/implement-trie-prefix-tree/">208. 实现 Trie (前缀树)</a>
 *
 * @author morningwn
 * @date Created in 2020-08-21 11:31
 */
public class T0208 {

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("abcbz");
        Out.println(trie.search("abc"));
        Out.println(trie.startsWith("a"));
    }

    class Trie {
        private final TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {

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

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            for (char w : chars) {
                if (cur.children[w - 'a'] == null) {
                    return false;
                }
                cur = cur.children[w - 'a'];
            }

            return cur.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            TrieNode cur = root;
            for (char w : chars) {
                if (cur.children[w - 'a'] == null) {
                    return false;
                }
                cur = cur.children[w - 'a'];
            }

            return true;
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


