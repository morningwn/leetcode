package com.github.morningwn.t0001_t0500.t0201_t0300.t0211_t0220;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 单词搜索 II
 *
 * @author moringwn
 * @date 2021/9/16 上午9:46
 */
public class T0212 {

    private TrieNode root;
    private Map<String, TrieNode> map;

    @Test
    public void test() {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain", "o", "a", "i"};

        Out.println(findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {

        // 初始化trie并插入数据
        root = new TrieNode();
        map = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            for (char w : chars) {
                if (cur.children[w - 'a'] == null) {
                    cur.children[w - 'a'] = new TrieNode(w);
                    cur.children[w - 'a'].parent = cur;
                }
                cur = cur.children[w - 'a'];
            }
            cur.isWord = true;
            cur.word = word;
            map.put(word, cur);
        }

        List<String> res = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                helper(res, root, board, i, j);
            }
        }

        return res;
    }


    private void helper(List<String> res, TrieNode node, char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 0 || node == null) {
            return;
        }

        char c = board[i][j];

        TrieNode children = node.getChildren(c);

        // 如果当前存在前缀或者单词
        if (children != null) {

            // 如果是一个单词
            if (children.isWord) {
                res.add(children.word);

                // 剪枝，删除当前单词的标记
                deleteNode(children.word);
            }

            board[i][j] = 0;
            // 上下左右
            helper(res, children, board, i + 1, j);
            helper(res, children, board, i - 1, j);
            helper(res, children, board, i, j + 1);
            helper(res, children, board, i, j - 1);

            // 恢复现场
            board[i][j] = c;
        }
    }

    private void deleteNode(String word) {
        TrieNode trieNode = map.get(word);

        map.remove(word);
        trieNode.isWord = false;

        // 如果有子节点就不删除了
        for (TrieNode child : trieNode.children) {
            if (child != null) {
                return;
            }
        }

        char[] chars = word.toCharArray();

        // 倒序，依次删除所有节点
        for (int i = chars.length - 1; i >= 0; i--) {

            trieNode = trieNode.parent;
            // 删除父节点中的引用
            trieNode.children[chars[i] - 'a'].parent = null;
            trieNode.children[chars[i] - 'a'] = null;

            // 如果是单词就不删除
            if (trieNode.isWord) {
                return;
            }
            // 如果有子节点就不删除
            for (TrieNode child : trieNode.children) {
                if (child != null) {
                    return;
                }
            }

        }
    }

}

class TrieNode {
    char val;
    TrieNode parent;
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
    }

    public TrieNode getChildren(char c) {
        return children[c - 'a'];
    }
}