package com.github.morningwn.create;

import java.util.List;

/**
 * @author morningwn
 * @date 2023/11/27 11:58
 */
public class GetById {

    public static void main(String[] args) {

        int id = 1653;
        List<String> list = Main.getList(id - 1, id + 50);
        try {
            Main.makeFile(Main.getDetail(list.get(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
