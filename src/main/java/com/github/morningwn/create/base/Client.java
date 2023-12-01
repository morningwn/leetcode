package com.github.morningwn.create.base;

import com.shuzijun.lc.LcClient;
import com.shuzijun.lc.command.CommonCommand;
import com.shuzijun.lc.command.CookieCommand;
import com.shuzijun.lc.command.QuestionCommand;
import com.shuzijun.lc.command.SubmissionCommand;
import com.shuzijun.lc.errors.LcException;
import com.shuzijun.lc.http.HttpClient;
import com.shuzijun.lc.model.*;
import org.junit.Assert;

import java.util.List;

/**
 * @author morningwn
 * @date 2023/11/27 15:08
 */
public class Client {
    private static LcClient lcClient;

    public static LcClient getLcClient() {
        if (lcClient != null) {
            return lcClient;
        }
        lcClient = LcClient.builder(HttpClient.SiteEnum.CN).build();
        // 从环境变量中获取cookie
        String cookie = "gr_user_id=c8ee9658-a911-419f-a3c4-5b4b2a4a8b02; _bl_uid=gplRkonwz9h5ts8gXw7774X2F0wg; a2873925c34ecbd2_gr_last_sent_cs1=morningwn; Hm_lvt_fa218a3ff7179639febdb15e372f411c=1700556210; csrftoken=zJLUb4K3v4hZd2nX5iVwcnav5p9k8wOyurDZE78dUfJQ61Spuyaws1CV9u41w7yh; LEETCODE_SESSION=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfYXV0aF91c2VyX2lkIjoiNjU4OTUyIiwiX2F1dGhfdXNlcl9iYWNrZW5kIjoiYXV0aGVudGljYXRpb24uYXV0aF9iYWNrZW5kcy5QaG9uZUF1dGhlbnRpY2F0aW9uQmFja2VuZCIsIl9hdXRoX3VzZXJfaGFzaCI6ImIzNTM0MjRhZjAyODY3ZDk1Zjk4YzkyYTNkNTlkMjEwODA4NGU4NDZiZmVmOGM0ZjQxMWJjZDgzM2VlY2MzOWMiLCJpZCI6NjU4OTUyLCJlbWFpbCI6Im1vcm5pbmd3bkAxMjYuY29tIiwidXNlcm5hbWUiOiJtb3JuaW5nd24iLCJ1c2VyX3NsdWciOiJtb3JuaW5nd24iLCJhdmF0YXIiOiJodHRwczovL2Fzc2V0cy5sZWV0Y29kZS5jbi9hbGl5dW4tbGMtdXBsb2FkL3VzZXJzL2RldmlsLTQwL2F2YXRhcl8xNTkzOTUzMjM0LnBuZyIsInBob25lX3ZlcmlmaWVkIjp0cnVlLCJfdGltZXN0YW1wIjoxNzAwNTYzNDcwLjk3NDY0OTIsImV4cGlyZWRfdGltZV8iOjE3MDMwOTg4MDAsInZlcnNpb25fa2V5XyI6MCwibGF0ZXN0X3RpbWVzdGFtcF8iOjE3MDA3MzQ2NTR9.fBS8LkUhrvGCHpxTQ5VdxN5unTzQ83uf-Z306r-GcWo; _gid=GA1.2.217881727.1701051331; Hm_lvt_f0faad39bcf8471e3ab3ef70125152c3=1700554681,1700704688,1701051331,1701056959; a2873925c34ecbd2_gr_session_id=a99ade0f-db38-409e-9f0a-6f80157039b4; a2873925c34ecbd2_gr_last_sent_sid_with_cs1=a99ade0f-db38-409e-9f0a-6f80157039b4; a2873925c34ecbd2_gr_session_id_sent_vst=a99ade0f-db38-409e-9f0a-6f80157039b4; Hm_lpvt_f0faad39bcf8471e3ab3ef70125152c3=1701070303; _ga=GA1.1.180083935.1699495250; a2873925c34ecbd2_gr_cs1=morningwn; _ga_PDVPZYN3CW=GS1.1.1701069569.18.1.1701070628.60.0.0";
        try {
            lcClient.invoker(CookieCommand.buildSetCookie(cookie));
            boolean t = lcClient.invoker(CommonCommand.buildVerify());
            Assert.assertTrue(t);
        } catch (LcException e) {
            e.printStackTrace();
        }
        return lcClient;
    }

    /**
     * @param pageIndex 从1开始
     * @param pageSize
     * @return
     */
    public static PageInfo<QuestionView> QuestionList(int pageIndex, int pageSize) {
        try {
            PageInfo<QuestionView> pageInfo = getLcClient().invoker(QuestionCommand.buildProblemSetQuestionList(new ProblemSetParam(pageIndex, pageSize)));
            return pageInfo;
        } catch (LcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Submission SubmissionList(String titleSlug) {
        try {
            List<Submission> submissions = getLcClient().invoker(SubmissionCommand.buildSubmissionList(titleSlug, 0, 10));
            return submissions.stream().filter(x -> x.getLang().equals("java")).findFirst().orElse(null);
        } catch (LcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SubmissionDetail SubmissionDetail(String submissionId) {
        try {
            SubmissionDetail submissionDetail = getLcClient().invoker(SubmissionCommand.buildSubmissionDetail(submissionId));
            return submissionDetail;
        } catch (LcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Question GetQuestion(String titleSlug) {
        try {
            Question question = getLcClient().invoker(QuestionCommand.buildGetQuestion(titleSlug));
            return question;
        } catch (LcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Question GetToday() {
        try {
            return getLcClient().invoker(QuestionCommand.buildQuestionOfToday());
        } catch (LcException e) {
            e.printStackTrace();
        }
        return null;
    }
}
