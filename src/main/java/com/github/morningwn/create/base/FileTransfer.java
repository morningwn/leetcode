package com.github.morningwn.create.base;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.github.morningwn.tag.Topic;
import com.shuzijun.lc.model.CodeSnippet;
import com.shuzijun.lc.model.Question;
import com.shuzijun.lc.model.SubmissionDetail;
import com.shuzijun.lc.model.TopicTag;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author morningwn
 * @date 2023/12/1 09:52
 */
public class FileTransfer {
    private static final Map<String, String> filePrefixMap = new HashMap<>();

    static {
        filePrefixMap.put("java", "J");
        filePrefixMap.put("c", "C");
    }


    public static Detail getDetail(Question question, SubmissionDetail submissionDetail) {
        Detail detail = new Detail();
        detail.setId(Integer.parseInt(question.getFrontendQuestionId()));
        detail.setTitle(question.getTitleCn());
        detail.setTitleSlug(question.getTitleSlug());
        detail.setPackageName("com.github.morningwn." + getPath(detail.getId()));
        detail.setFileDir(getPath(detail.getId()));
        detail.setFileSuffix(format(detail.getId()));
        detail.setDifficulty(question.getLevel());

        detail.setTopics(question.getTopicTags().stream()
                .filter(Objects::nonNull)
                .map(TopicTag::getName)
                .filter(StringUtils::isNotBlank)
                .map(x -> getTag(x))
                .distinct()
                .peek(x -> {
                    for (Topic value : Topic.values()) {
                        if (value.name().equals(x)) {
                            return;
                        }
                    }
                    System.out.println(x);
                })
                .collect(Collectors.toList()));

        if (Objects.nonNull(submissionDetail)) {
            detail.setDataTime(DateUtil.formatDateTime(DateTime.of(Long.parseLong(submissionDetail.getTimestamp()) * 1000)));
            String javaCode = parsePassJavaCode(submissionDetail.getSubmissionCode());
            detail.setImportClassList(parseImport(javaCode));
            detail.setJavaCode(javaCode);
        } else {
            for (CodeSnippet codeSnippet : question.getCodeSnippets()) {
                String langSlug = codeSnippet.getLangSlug();
                if (langSlug.equals("java")) {
                    String javaCode = parseJavaCode(codeSnippet.getCode());
                    detail.setImportClassList(parseImport(javaCode));
                    detail.setJavaCode(javaCode);
                } else if (langSlug.equals("c")) {
                    detail.setcCode(codeSnippet.getCode());
                }
            }
        }
        return detail;
    }

    private static String getPath(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append('t');
        sb.append(format(((id - 1) / 500) * 500 + 1));
        sb.append('_');
        sb.append('t');
        sb.append(format(((id - 1) / 500) * 500 + 500));

        sb.append('.');

        sb.append('t');
        sb.append(format(((id - 1) / 100) * 100 + 1));
        sb.append('_');
        sb.append('t');
        sb.append(format(((id - 1) / 100) * 100 + 100));

        sb.append('.');

        sb.append('t');
        sb.append(format(((id - 1) / 10) * 10 + 1));
        sb.append('_');
        sb.append('t');
        sb.append(format(((id - 1) / 10) * 10 + 10));

        return sb.toString();
    }

    private static String format(int i) {
        return String.format("%04d", i);
    }

    private static String parseJavaCode(String javacode) {
        String replace = javacode
                .replace("public class Solution {", "")
                .replace("class Solution {\\n", "")
                .replace("class Solution {", "")
                .replace("/**\n" +
                        " * Definition for singly-linked list.\n" +
                        " * public class ListNode {\n" +
                        " *     int val;\n" +
                        " *     ListNode next;\n" +
                        " *     ListNode() {}\n" +
                        " *     ListNode(int val) { this.val = val; }\n" +
                        " *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }\n" +
                        " * }\n" +
                        " */", "")
                .replace("/**\n" +
                        " * Definition for a binary tree node.\n" +
                        " * public class TreeNode {\n" +
                        " *     int val;\n" +
                        " *     TreeNode left;\n" +
                        " *     TreeNode right;\n" +
                        " *     TreeNode() {}\n" +
                        " *     TreeNode(int val) { this.val = val; }\n" +
                        " *     TreeNode(int val, TreeNode left, TreeNode right) {\n" +
                        " *         this.val = val;\n" +
                        " *         this.left = left;\n" +
                        " *         this.right = right;\n" +
                        " *     }\n" +
                        " * }\n" +
                        " */", "")
                .replace("/**\n" +
                        " * Definition for a binary tree node.\n" +
                        " * public class TreeNode {\n" +
                        " * int val;\n" +
                        " * TreeNode left;\n" +
                        " * TreeNode right;\n" +
                        " * TreeNode(int x) { val = x; }\n" +
                        " * }\n" +
                        " * }", "")
                .replace("/*\n" +
                        "// Definition for a Node.\n" +
                        "class Node {\n" +
                        "    public int val;\n" +
                        "    public Node left;\n" +
                        "    public Node right;\n" +
                        "    public Node next;\n" +
                        "\n" +
                        "    public Node() {}\n" +
                        "    \n" +
                        "    public Node(int _val) {\n" +
                        "        val = _val;\n" +
                        "    }\n" +
                        "\n" +
                        "    public Node(int _val, Node _left, Node _right, Node _next) {\n" +
                        "        val = _val;\n" +
                        "        left = _left;\n" +
                        "        right = _right;\n" +
                        "        next = _next;\n" +
                        "    }\n" +
                        "};\n" +
                        "*/", "")
                .replace("/**\n" +
                        " * Definition for a binary tree node.\n" +
                        " * public class TreeNode {\n" +
                        " *     int val;\n" +
                        " *     TreeNode left;\n" +
                        " *     TreeNode right;\n" +
                        " *     TreeNode(int x) { val = x; }\n" +
                        " * }\n" +
                        " */", "");

        if (replace.contains("public Solution(")) {
            return "";
        }
        if (replace.contains("class ")) {
            return "";
        }
        if (replace.contains("public int ")) {
            int i = replace.indexOf("}");

            return replace.substring(0, i) + "return 0;\n    " + "}";
        }
        if (replace.contains("public long ")) {
            int i = replace.indexOf("}");

            return replace.substring(0, i) + "return 0L;\n    " + "}";
        }
        if (replace.contains("public double ")) {
            int i = replace.indexOf("}");

            return replace.substring(0, i) + "return 0.0;\n    " + "}";
        }
        if (replace.contains("public char ")) {
            int i = replace.indexOf("}");

            return replace.substring(0, i) + "return ' ';\n    " + "}";
        }
        if (replace.contains("public boolean ")) {
            int i = replace.indexOf("}");

            return replace.substring(0, i) + "return false;\n    " + "}";
        }
        if (!replace.contains("void")) {
            int i = replace.indexOf("}");

            return replace.substring(0, i) + "return null;\n    " + "}";
        }

        return replace.substring(0, replace.lastIndexOf("}"));
    }

    private static String parsePassJavaCode(String javacode) {
        String replace = javacode
                .replace("public class Solution {", "")
                .replace("class Solution {\n", "")
                .replace("class Solution     {", "")
                .replace("/**\n" +
                        " * Definition for singly-linked list.\n" +
                        " * public class ListNode {\n" +
                        " *     int val;\n" +
                        " *     ListNode next;\n" +
                        " *     ListNode(int x) { val = x; }\n" +
                        " * }\n" +
                        " */", "")
                .replace("/**\n" +
                        " * Definition for a binary tree node.\n" +
                        " * public class TreeNode {\n" +
                        " *     int val;\n" +
                        " *     TreeNode left;\n" +
                        " *     TreeNode right;\n" +
                        " *     TreeNode() {}\n" +
                        " *     TreeNode(int val) { this.val = val; }\n" +
                        " *     TreeNode(int val, TreeNode left, TreeNode right) {\n" +
                        " *         this.val = val;\n" +
                        " *         this.left = left;\n" +
                        " *         this.right = right;\n" +
                        " *     }\n" +
                        " * }\n" +
                        " */", "")
                .replace("/**\n" +
                        " * Definition for a binary tree node.\n" +
                        " * public class TreeNode {\n" +
                        " * int val;\n" +
                        " * TreeNode left;\n" +
                        " * TreeNode right;\n" +
                        " * TreeNode(int x) { val = x; }\n" +
                        " * }\n" +
                        " * }", "")
                .replace("/*\n" +
                        "// Definition for a Node.\n" +
                        "class Node {\n" +
                        "    public int val;\n" +
                        "    public Node left;\n" +
                        "    public Node right;\n" +
                        "    public Node next;\n" +
                        "\n" +
                        "    public Node() {}\n" +
                        "    \n" +
                        "    public Node(int _val) {\n" +
                        "        val = _val;\n" +
                        "    }\n" +
                        "\n" +
                        "    public Node(int _val, Node _left, Node _right, Node _next) {\n" +
                        "        val = _val;\n" +
                        "        left = _left;\n" +
                        "        right = _right;\n" +
                        "        next = _next;\n" +
                        "    }\n" +
                        "};\n" +
                        "*/", "")
                .replace("/**\n" +
                        " * Definition for a binary tree node.\n" +
                        " * public class TreeNode {\n" +
                        " *     int val;\n" +
                        " *     TreeNode left;\n" +
                        " *     TreeNode right;\n" +
                        " *     TreeNode(int x) { val = x; }\n" +
                        " * }\n" +
                        " */", "");

        return replace.substring(0, replace.length() - 1);
    }

    private static List<String> parseImport(String javaCode) {
        List<String> importClassList = new ArrayList<>();

        if (javaCode.contains("List")) {
            importClassList.add("java.util.List;");
        }

        if (javaCode.contains("ListNode")) {
            importClassList.add("com.github.morningwn.prefab.ListNode;");
        }
        if (javaCode.contains("Node")) {
            importClassList.add("com.github.morningwn.prefab.Node;");
        }
        if (javaCode.contains("TreeNode")) {
            importClassList.add("com.github.morningwn.prefab.TreeNode;");
        }
        if (javaCode.contains("Map")) {
            importClassList.add("java.util.Map;");
        }
        if (javaCode.contains("Set")) {
            importClassList.add("java.util.Set;");
        }
        if (javaCode.contains("HashMap")) {
            importClassList.add("java.util.HashMap;");
        }
        if (javaCode.contains("LinkedList")) {
            importClassList.add("java.util.LinkedList;");
        }
        if (javaCode.contains("Arrays")) {
            importClassList.add("java.util.Arrays;");
        }
        if (javaCode.contains("ArrayList")) {
            importClassList.add("java.util.ArrayList;");
        }
        return importClassList;
    }

    private static String getTag(String x) {
        x = x.replaceAll(" ", "");
        if (x.equals("Heap(PriorityQueue)")) {
            return "PriorityQueue";
        }
        if (x.equals("Depth-FirstSearch")) {
            return "DepthFirstSearch";
        }
        return x;
    }

}
