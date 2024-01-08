package com.github.morningwn.create;

import com.github.morningwn.create.base.Client;
import com.github.morningwn.create.base.Detail;
import com.github.morningwn.create.base.FileMaker;
import com.github.morningwn.create.base.FileTransfer;
import com.github.morningwn.prefab.Out;
import com.shuzijun.lc.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author morningwn
 * @date 2023/11/27 11:58
 */
public class GetById {

    public static void main(String[] args) {
        int id = 538;
        getOne(449);
//        getList(531, 540);
    }

    private static void getOne(int id) {
        PageInfo<QuestionView> questionList = Client.QuestionList(id, 1);
        QuestionView questionView = questionList.getRows().get(0);
        Question question = Client.GetQuestion(questionView.getTitleSlug());
        Map<String, SubmissionDetail> submissionDetailMap = Client.SubmissionDetailByTitleSlug(questionView.getTitleSlug());
        Detail detail = FileTransfer.getDetail(question, submissionDetailMap);
        FileMaker.makeAllFile(detail);
    }

    private static void getList(int start, int end) {
        PageInfo<QuestionView> questionList = Client.QuestionList((start / 10) + 1, 10);
        for (QuestionView questionView : questionList.getRows()) {
            Question question = Client.GetQuestion(questionView.getTitleSlug());
            Map<String, SubmissionDetail> submissionDetailMap = Client.SubmissionDetailByTitleSlug(questionView.getTitleSlug());
            Detail detail = FileTransfer.getDetail(question, submissionDetailMap);
            FileMaker.makeAllFile(detail);
        }
    }
}
