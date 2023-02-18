package com.github.morningwn.t1501_t2000.t1601_t1700.t1601_t1610;


import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/">1604. 警告一小时内使用相同员工卡大于等于三次的人</a>
 *
 * @author morningwn
 * @create in 2023/2/7 20:02
 */
public class T1604 {

    @Test
    public void test() {
        String[] keyName = {"john", "john", "john"};
        String[] keyTime = {"23:58", "23:59", "00:01"};

        Out.print(alertNames(keyName, keyTime));
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, PriorityQueue<Integer>> employeeTimes = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            PriorityQueue<Integer> times = employeeTimes.computeIfAbsent(keyName[i], k -> new PriorityQueue<>(Integer::compareTo));
            times.offer(translateTime(keyTime[i]));
        }
        List<String> alertNames = new ArrayList<>();

        for (Map.Entry<String, PriorityQueue<Integer>> entry : employeeTimes.entrySet()) {
            PriorityQueue<Integer> times = entry.getValue();
            if (times.size() < 3) {
                continue;
            }
            int t1 = times.poll();
            int t2 = times.poll();
            while (!times.isEmpty()) {
                int cur = times.poll();
                if (cur - t1 <= 60 && cur - t2 <= 60) {
                    alertNames.add(entry.getKey());
                    break;
                } else {
                    t1 = t2;
                    t2 = cur;
                }
            }
        }

        alertNames.sort(String::compareTo);
        return alertNames;
    }

    private int translateTime(String t) {
        int th = (t.charAt(0) - '0') * 10 + t.charAt(1) - '0';
        int tm = (t.charAt(3) - '0') * 10 + t.charAt(4) - '0';
        return th * 60 + tm;
    }

}
