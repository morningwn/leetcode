package com.github.morningwn.create;

import com.github.morningwn.create.base.Client;
import com.github.morningwn.create.base.Detail;
import com.github.morningwn.create.base.FileMaker;
import com.github.morningwn.create.base.FileTransfer;
import com.shuzijun.lc.model.Question;

import java.util.HashMap;

/**
 * @author morningwn
 * @date 2023/11/21 16:33
 */
public class Today {

    public static void main(String[] args) {
        Question question = Client.GetToday();
        Detail detail = FileTransfer.getDetail(question, new HashMap<>());
        FileMaker.makeAllFile(detail);
    }

}
