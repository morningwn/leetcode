package com.github.morningwn.create;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author morningwn
 * @create in 2022/8/15 17:42
 */
public class Main {

    private static String baseDir = "/Users/mac/IdeaProjects/leetcode/src/main/java/";

    public static final String graphql = "https://leetcode-cn.com/graphql";
    public static String detailReq1 = "{  \"operationName\": \"questionData\",  \"variables\": {    \"titleSlug\": \"";
    public static String detailReq2 = "\"  },  \"query\": \"query questionData($titleSlug: String!) {\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n    boundTopicId\\n    title\\n    titleSlug\\n    content\\n    translatedTitle\\n    translatedContent\\n    isPaidOnly\\n    difficulty\\n    likes\\n    dislikes\\n    isLiked\\n    similarQuestions\\n    contributors {\\n      username\\n      profileUrl\\n      avatarUrl\\n      __typename\\n    }\\n    langToValidPlayground\\n    topicTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    companyTagStats\\n    codeSnippets {\\n      lang\\n      langSlug\\n      code\\n      __typename\\n    }\\n    stats\\n    hints\\n    solution {\\n      id\\n      canSeeDetail\\n      __typename\\n    }\\n    status\\n    sampleTestCase\\n    metaData\\n    judgerAvailable\\n    judgeType\\n    mysqlSchemas\\n    enableRunCode\\n    enableTestMode\\n    envInfo\\n    __typename\\n  }\\n}\\n\"}";

    public static String tagReq = "{  \"query\": \"\\n    query questionTagTypeWithTags {\\n  questionTagTypeWithTags {\\n    name\\n    transName\\n    tagRelation {\\n      questionNum\\n      tag {\\n        name\\n        id\\n        nameTranslated\\n        slug\\n      }\\n    }\\n  }\\n}\\n    \",  \"variables\": {}}";

    public static String listReq1 = "{ \"query\": \"\\n    query problemsetQuestionList($categorySlug: String, $limit: Int, $skip: Int, $filters: QuestionListFilterInput) {\\n  problemsetQuestionList(\\n    categorySlug: $categorySlug\\n    limit: $limit\\n    skip: $skip\\n    filters: $filters\\n  ) {\\n    hasMore\\n    total\\n    questions {\\n      acRate\\n      difficulty\\n      freqBar\\n      frontendQuestionId\\n      isFavor\\n      paidOnly\\n      solutionNum\\n      status\\n      title\\n      titleCn\\n      titleSlug\\n      topicTags {\\n        name\\n        nameTranslated\\n        id\\n        slug\\n      }\\n      extra {\\n        hasVideoSolution\\n        topCompanyTags {\\n          imgUrl\\n          slug\\n          numSubscribed\\n        }\\n      }\\n    }\\n  }\\n}\\n    \", \"variables\": {   \"categorySlug\": \"\",   \"skip\": ";
    public static String listReq2 = ",   \"limit\": ";
    public static String listReq3 = ",   \"filters\": {} }}";

    public static void main(String[] args) throws TemplateException, IOException {
//        getTag();
        for (int i = 0; i < 5000; i += 100) {
            String path = getPath(i);
            File file = new File(baseDir + path.replaceAll("\\.", "/") + "/");
            if (!file.exists()) {
                file.mkdirs();
            }
//            for (String titleSlug : getList(i, i + 100)) {
//                Detail detail = getDetail(titleSlug);
//                if (detail == null) {
//                    continue;
//                }
//                makeFile(detail);
//            }
        }

    }

    public static Detail getDetail(String titleSlug) {
        HttpRequest post = HttpUtil.createPost(graphql);
        post.body(detailReq1 + titleSlug + detailReq2);
        HttpResponse response = post.execute();

        System.out.println(response.body());
        JSON resp = JSONUtil.parse(response.body());

        JSONObject jsonDetail = resp.getByPath("data.question", JSONObject.class);
        Detail detail = new Detail();
        detail.setId(jsonDetail.getByPath("questionFrontendId", Integer.class));
        detail.setTitle(jsonDetail.getByPath("translatedTitle", String.class));
        detail.setTitleSlug(jsonDetail.getByPath("titleSlug", String.class));
        detail.setPackageName("com.github.morningwn." + getPath(detail.getId()));
        detail.setClassName("J" + format(detail.getId()));
        JSONArray codeSnippets = jsonDetail.getByPath("codeSnippets", JSONArray.class);
        if (codeSnippets == null) {
            return null;
        }
        Iterator<JSONObject> iterator = codeSnippets.jsonIter().iterator();
        while (iterator.hasNext()) {
            JSONObject codeSnippet = iterator.next();
            if (codeSnippet.getByPath("langSlug", String.class).equals("java")) {
                String javacode = codeSnippet.getByPath("code", String.class);
                String s = parseJavaCode(javacode);
                detail.setImportClassList(parseImport(s));
                detail.setJavaCode(s);
                return detail;
            }
        }
//        System.out.println(JSONUtil.toJsonStr(detail));

        return null;
    }

    public static String parseJavaCode(String javacode) {
        String replace = javacode
                .replace("public class Solution {", "")
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
                        " */", "")
                ;

        if (replace.contains("public Solution(")){
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

    public static List<String> parseImport(String javaCode) {
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
        return importClassList;
    }

    public static void getTag() {
        HttpRequest post = HttpUtil.createPost(graphql);
        post.body(tagReq);
        HttpResponse response = post.execute();
        System.out.println(response.body());

        JSON resp = JSONUtil.parse(response.body());
        JSONArray tags = JSONUtil.getByPath(resp, "data.questionTagTypeWithTags", new JSONArray());
        System.out.println(tags);
        Iterator<JSONObject> iterator = tags.jsonIter().iterator();

        while (iterator.hasNext()) {
            JSONObject tagsList = iterator.next();
            JSONArray tagList = tagsList.getByPath("tagRelation", JSONArray.class);
            Iterator<JSONObject> tagI = tagList.jsonIter().iterator();
            while (tagI.hasNext()) {
                JSONObject tag = tagI.next();
                System.out.println(tag);

                System.out.println(tag.getByPath("tag.nameTranslated"));
            }
        }

    }

    public static List<String> getList(int skip, int size) {
        List<String> titleList = new ArrayList<>();

        HttpRequest post = HttpUtil.createPost(graphql);
        post.body(listReq1 + skip + listReq2 + size + listReq3);
        HttpResponse response = post.execute();
        JSON resp = JSONUtil.parse(response.body());
        JSONArray list = resp.getByPath("data.problemsetQuestionList.questions", JSONArray.class);
        Iterator<JSONObject> iterator = list.jsonIter().iterator();
        while (iterator.hasNext()) {
            JSONObject p = iterator.next();
            String titleSlug = p.getByPath("titleSlug", String.class);
            titleList.add(titleSlug);
        }

        return titleList;
    }

    public static String getPath(int id) {
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

    public static String format(int i) {
        return String.format("%04d", i);
    }

    public static void makeFile(Detail detail) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);

        cfg.setDirectoryForTemplateLoading(new File("/Users/mac/IdeaProjects/leetcode/src/main/java/com/github/morningwn/create"));
        Template template = cfg.getTemplate("Java.ftl");
        File file = new File(baseDir + detail.getPackageName().replaceAll("\\.", "/") + "/" + detail.getClassName() + ".java");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileWriter fileWriter = new FileWriter(file);
        template.process(detail, fileWriter);
    }

}
