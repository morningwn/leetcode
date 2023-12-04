package com.github.morningwn.create;

import com.github.morningwn.create.base.Client;
import com.github.morningwn.create.base.Detail;
import com.github.morningwn.create.base.FileMaker;
import com.github.morningwn.create.base.FileTransfer;
import com.github.morningwn.prefab.Out;
import com.shuzijun.lc.model.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author morningwn
 * @date 2023/11/27 11:58
 */
public class GetById {

    public static void main(String[] args) {

        int id = 538;
        PageInfo<QuestionView> questionList = Client.QuestionList(id, 1);
        QuestionView questionView = questionList.getRows().get(0);
        Question question = Client.GetQuestion(questionView.getTitleSlug());
        Detail detail = FileTransfer.getDetail(question, null);
        FileMaker.makeAllFile(detail);
    }
}
