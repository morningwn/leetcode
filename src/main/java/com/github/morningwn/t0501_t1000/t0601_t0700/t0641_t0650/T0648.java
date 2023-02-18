package com.github.morningwn.t0501_t1000.t0601_t0700.t0641_t0650;


import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/replace-words/">648. 单词替换</a>
 *
 * @author morningwn
 * @create in 2022/7/7 10:07
 */
public class T0648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        Trie trie = new Trie();

        for (String s : dictionary) {
            trie.insert(s);
        }

        for (String word : words) {
            String tmp = trie.search(word);
            if (tmp != null) {
                sb.append(tmp);
            } else {
                sb.append(word);
            }
            sb.append(' ');
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
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
            cur.word = word;
        }

        /**
         * Returns if the word is in the trie.
         */
        public String search(String word) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            for (char w : chars) {
                if (cur.children[w - 'a'] == null || cur.isWord) {
                    break;
                }
                cur = cur.children[w - 'a'];
            }

            if (cur.isWord) {
                return cur.word;
            } else {
                return null;
            }
        }
    }

    class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;
        String word;

        public TrieNode() {
            this(' ');
        }

        public TrieNode(char val) {
            this.val = val;
            children = new TrieNode[26];
            isWord = false;
            word = null;
        }
    }
}
