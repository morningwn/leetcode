package com.github.morningwn.create;

import com.github.morningwn.create.base.Client;
import com.shuzijun.lc.model.PageInfo;
import com.shuzijun.lc.model.QuestionView;

import java.util.List;

/**
 * @author morningwn
 * @date 2023/11/27 11:58
 */
public class GetById {

    public static void main(String[] args) {

        int id = 1653;
        PageInfo<QuestionView> questionList = Client.QuestionList(id + 1, 1);

    }
}
