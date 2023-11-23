package com.github.morningwn.create;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangjianing
 * @date 2023/11/21 16:33
 */
public class Today {

    public static void main(String[] args) {
        getToday();
    }

    public static void getToday() {
//        String param = "{\"query\":\"\\n    query questionOfToday {\\n  todayRecord {\\n    date\\n    userStatus\\n    question {\\n      questionId\\n      frontendQuestionId: questionFrontendId\\n      difficulty\\n      title\\n ";
        Map<String, Object> param = new HashMap<>();
        param.put("query", "\n    query questionOfToday {\n  todayRecord {\n    date\n    userStatus\n    question {\n      questionId\n      frontendQuestionId: questionFrontendId\n      difficulty\n      title\n      titleCn: translatedTitle\n      titleSlug\n      paidOnly: isPaidOnly\n      freqBar\n      isFavor\n      acRate\n      status\n      solutionNum\n      hasVideoSolution\n      topicTags {\n        name\n        nameTranslated: translatedName\n        id\n      }\n      extra {\n        topCompanyTags {\n          imgUrl\n          slug\n          numSubscribed\n        }\n      }\n    }\n    lastSubmission {\n      id\n    }\n  }\n}\n");
        param.put("variables", "{}");
        param.put("operationName", "questionOfToday");
        HttpRequest post = HttpUtil.createPost(Main.graphql);
        post.body(JSONUtil.toJsonStr(param));
        HttpResponse response = post.execute();
        System.out.println(response.body());
        JSON resp = JSONUtil.parse(response.body());
        JSONObject todayRecord = resp.getByPath("data.todayRecord", JSONArray.class).get(0, JSONObject.class);

        Integer frontendQuestionId =  todayRecord.getByPath("question.frontendQuestionId", Integer.class);
        System.out.println(frontendQuestionId);
        String path = Main.getPath(frontendQuestionId);
        System.out.println(path);

        String titleSlug = todayRecord.getByPath("question.titleSlug", String.class);
        Detail detail = Main.getDetail(titleSlug);
        System.out.println(JSONUtil.toJsonStr(detail));
        try {
            Main.makeFile(detail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
