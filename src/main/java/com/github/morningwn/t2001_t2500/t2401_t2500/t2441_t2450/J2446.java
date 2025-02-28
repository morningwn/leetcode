package com.github.morningwn.t2001_t2500.t2401_t2500.t2441_t2450;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/determine-if-two-events-have-conflict/">2446. 判断两个事件是否存在冲突</a>
 *
 * @author morningwn
 * @create in 2023/5/17 11:38
 */
public class J2446 {

    @Test
    public void test() {
        String time = "11:01";
        Out.println(parseTime(time));
    }

    /**
     * 可以直接比较字符串
     *
     * @param event1
     * @param event2
     * @return
     */
    public boolean haveConflict(String[] event1, String[] event2) {
        int e1Start = parseTime(event1[0]);
        int e1End = parseTime(event1[1]);
        int e2Start = parseTime(event2[0]);
        int e2End = parseTime(event2[1]);

        if (e1Start <= e2Start && e2Start <= e1End) {
            return true;
        }
        if (e2Start <= e1Start && e1Start <= e2End) {
            return true;
        }

        return false;
    }

    private int parseTime(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }

}
