package com.github.morningwn.t1001_t1500.t1401_t1500.t1481_t1490;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/making-file-names-unique/">1487. 保证文件名唯一</a>
 *
 * @author morningwn
 * @date Created in 2023/3/3 10:33
 */
public class J1487 {

    @Test
    public void test() {
        String[] names = {"pes","fifa","gta","pes(2019)"};
        String[] folderNames = getFolderNames(names);
        Out.println(folderNames);
    }

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> folderMap = new HashMap<>(names.length);
        String[] folders = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            int count = folderMap.getOrDefault(names[i], 0);
            String folder = null;
            if (count != 0) {
                folder = names[i] + "(" + count + ")";
            } else {
                folder = names[i];
            }
            while (folderMap.containsKey(folder)) {
                count++;
                folder = names[i] + "(" + count + ")";
            }
            folderMap.put(names[i], count);
            folderMap.put(folder, 1);
            folders[i] = folder;
        }

        return folders;
    }
}
