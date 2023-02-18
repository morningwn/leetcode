package com.github.morningwn.t0501_t1000.t0801_t0900.t0851_t0860;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/exam-room/">855. 考场就座</a>
 *
 * @author morningwn
 * @create in 2022/12/30 18:38
 */
public class T0855 {

    @Test
    public void test1() {
        ExamRoom examRoom = new ExamRoom(10);
        Out.println(examRoom.seat()); // 0
        Out.println(examRoom.seat()); // 9
        Out.println(examRoom.seat()); // 4
        Out.println(examRoom.seat()); // 2
        examRoom.leave(4);
        Out.println(examRoom.seat());  // 5
    }

    @Test
    public void test2() {
        ExamRoom examRoom = new ExamRoom(1000000);
        Out.println(examRoom.seat()); // 0
        Out.println(examRoom.seat()); // 999999
        Out.println(examRoom.seat()); // 499999
        Out.println(examRoom.seat()); // 749999
        examRoom.leave(0);
        Out.println(examRoom.seat());  // 0
        Out.println(examRoom.seat());  // 249999
        Out.println(examRoom.seat());  // 374999
        Out.println(examRoom.seat());  // 624999
    }

    class ExamRoom {
        private TreeSet<Integer> seat;
        private int n;

        public ExamRoom(int n) {
            this.seat = new TreeSet<>(Integer::compare);
            this.n = n;
        }

        public int seat() {
            if (seat.size() == 0) {
                seat.add(0);
                return 0;
            }
            int res = 0;
            int distance = 0;
            int pre = 0;
            if (seat.first() != 0) {
                res = 0;
                distance = seat.first();
            }
            for (Integer i : seat) {
                int tmpI = ((i - pre) / 2) + pre;
                int min = Math.min(tmpI - pre, i - tmpI);
                if (min > distance) {
                    distance = min;
                    res = tmpI;
                }
                pre = i;
            }
            if (pre != n - 1 && n - 1 - pre > distance) {
                res = n - 1;
            }
            seat.add(res);
            return res;
        }

        public void leave(int p) {
            this.seat.remove(p);
        }
    }
}
