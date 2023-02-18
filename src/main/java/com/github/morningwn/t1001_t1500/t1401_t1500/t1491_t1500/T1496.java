package com.github.morningwn.t1001_t1500.t1401_t1500.t1491_t1500;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/path-crossing/">1496. 判断路径是否相交</a>
 *
 * @author morningwn
 * @create in 2022/8/4 17:07
 */
public class T1496 {

    @Test
    public void test() {
        String path = "NESWW";

        Out.println(isPathCrossing(path));

        Out.println(Integer.toString(10000, 2));

        Out.println(Integer.toString(makePoint(10000, 10000), 2));
    }

    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        char[] directions = path.toCharArray();

        for (char direction : directions) {
            if (direction == 'N') {
                y++;
            } else if (direction == 'S') {
                y--;
            } else if (direction == 'E') {
                x++;
            } else {
                x--;
            }

            int point = makePoint(x, y);
            if (set.contains(point)) {
                return true;
            } else {
                set.add(point);
            }
        }
        return false;
    }

    private int makePoint(int x, int y) {
        return (x << 15) + y;
    }
}
