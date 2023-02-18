package com.github.morningwn.t1001_t1500.t1201_t1300.t1231_t1240;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/">1233. 删除子文件夹</a>
 *
 * @author morningwn
 * @create in 2023/2/8 22:47
 */
public class T1233 {

    public List<String> removeSubfolders(String[] folder) {
        List<String> folders = new ArrayList<>();
        Arrays.sort(folder);
        folders.add(folder[0]);
        String pre = folder[0] + "/";

        for (int i = 1; i < folder.length; i++) {
            if (folder[i].indexOf(pre) != 0) {
                folders.add(folder[i]);
                pre = folder[i] + "/";
            }
        }
        return folders;
    }
}
