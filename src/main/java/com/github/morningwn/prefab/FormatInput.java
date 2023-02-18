package com.github.morningwn.prefab;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;


/**
 * @author morningwn
 * @date 2020/10/26 12:05
 */
public class FormatInput {

    public static String readStr(String filePath) {
        File file = new File(filePath);
        try (FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8)){
            int len = 0;
            char[] bff = new char[1024];
            StringBuilder sb = new StringBuilder();
            while ((len = fileReader.read(bff)) != -1) {
                sb.append(bff, 0, len);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] stringToArray(String s) {
        s = s.substring(1, s.length() - 1);

        String[] strings = s.split(",");
        int[] res = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            res[i] = Integer.parseInt(strings[i].trim());
        }

        return res;
    }

    /**
     * [[],[]] -> {{}, {}}
     *
     * @param s
     * @param n
     * @return
     */
    public static int[][] stringTo2Array(String s, int n) {
        s = s.substring(2, s.length() - 2);
        String[] strings = s.split("]");
        int[][] res = new int[strings.length][n];
        for (int i = 0; i < strings.length; i++) {
            String[] split = strings[i].replace(",[", "").replace("[", "").split(",");
            for (int j = 0; j < n; j++) {
                res[i][j] = Integer.parseInt(split[j]);
            }
        }
        return res;
    }


    public static TreeNode formatTreeNode(String str) {
        if (str.length() < 3) {
            return null;
        }
        str = str.substring(1, str.length() - 1);

        String[] strings = str.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        int index = 1;
        int length = strings.length;
        while (index < length) {
            TreeNode node = deque.pollFirst();
            if (index < length) {
                if (!"null".equals(strings[index])) {
                    node.left = new TreeNode(Integer.parseInt(strings[index++]));
                    deque.addLast(node.left);
                } else {
                    index++;
                }
            }

            if (index < length) {
                if (!"null".equals(strings[index])) {
                    node.right = new TreeNode(Integer.parseInt(strings[index++]));
                    deque.addLast(node.right);
                } else {
                    index++;
                }
            }
        }

        return root;
    }
}
