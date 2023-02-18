package com.github.morningwn.t0001_t0500.t0201_t0300.t0211_t0220;


/**
 * 添加与搜索单词 - 数据结构设计
 *
 * @author moringwn
 * @date 2021/10/19 上午9:35
 */
public class T0211 {

    class WordDictionary {
        private final TrieNode header;

        public WordDictionary() {
            this.header = new TrieNode();
        }

        public void addWord(String word) {
            char[] chars = word.toCharArray();
            TrieNode cur = header;
            for (char w : chars) {
                if (cur.children[w - 'a'] == null) {
                    cur.children[w - 'a'] = new TrieNode(w);
                }
                cur = cur.children[w - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();

            return helper(chars, 0, this.header);
        }

        private boolean helper(char[] chars, int i, TrieNode header) {

            if (i >= chars.length) {
                if (header == null) {
                    return false;
                } else {
                    return header.isWord;
                }
            }

            if (chars[i] == '.') {
                for (TrieNode child : header.children) {
                    if (child != null) {
                        if (helper(chars, i + 1, child)) {
                            return true;
                        }
                    }
                }
            } else {
                TrieNode child = header.getChild(chars[i]);
                if (child != null) {
                    return helper(chars, i + 1, child);
                }
            }
            return false;
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

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }

    }
}


