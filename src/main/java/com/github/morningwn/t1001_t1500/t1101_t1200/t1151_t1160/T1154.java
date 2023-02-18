package com.github.morningwn.t1001_t1500.t1101_t1200.t1151_t1160;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/day-of-the-year/">1154. 一年中的第几天</a>
 *
 * @author moringwn
 * @date 2021/12/21 上午11:59
 */
public class T1154 {

    private static final int[] MONTH_DAY = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    @Test
    public void test() {

        String date = "2021-12-12";

        Out.println(dayOfYear(date));
    }

    public int dayOfYear(String date) {

        String[] yyyyMMdd = date.split("-");

        int year = Integer.parseInt(yyyyMMdd[0]);
        int month = Integer.parseInt(yyyyMMdd[1]);
        int day = Integer.parseInt(yyyyMMdd[2]);

        if ((year % 4 == 0 && year % 100 != 0) || year % 200 == 0) {
            if (month > 2) {
                return MONTH_DAY[month] + day + 1;
            } else {
                return MONTH_DAY[month] + day;
            }
        } else {
            return MONTH_DAY[month] + day;
        }
    }
}
