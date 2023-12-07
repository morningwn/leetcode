package com.github.morningwn.t1001_t1500.t1401_t1500.t1461_t1470;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <a href="https://leetcode.cn/problems/course-schedule-iv/">1462. 课程表 IV</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#DepthFirstSearch}</li>
 * <li>{@link Topic#BreadthFirstSearch}</li>
 * <li>{@link Topic#Graph}</li>
 * <li>{@link Topic#TopologicalSort}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-09-12 21:42:47
 */
public class J1462 {

    @Test
    public void test() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[][] queries = {{0, 1}, {1, 0}};
        Out.println(checkIfPrerequisite(numCourses, prerequisites, queries));
        Out.println(buildAllQueriesTest(100));

        Out.println(buildPrerequisitesTest(100, 322));
        Out.println(buildPrerequisitesTest(100, 321));
    }

    private int[][] buildPrerequisitesTest(int numCourses, int length) {
        int[][] sides = new int[numCourses][numCourses];
        Random r = new Random();
        int[][] ints = new int[length][2];
        for (int i = 0; i < length; i++) {
            int m = r.nextInt(numCourses);
            int n = r.nextInt(numCourses);
            while (sides[m][n] != 0 || sides[n][m] != 0 || m == n) {
                m = r.nextInt(numCourses);
                n = r.nextInt(numCourses);
            }
            sides[m][n] = 1;
            sides[n][m] = 1;
            ints[i][0] = m;
            ints[i][1] = n;
        }

        return ints;
    }

    private int[][] buildAllQueriesTest(int numCourses) {
        int[][] ints = new int[numCourses * numCourses - numCourses][2];
        int offset = 0;
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (i != j) {
                    ints[i * numCourses + j - offset][0] = i;
                    ints[i * numCourses + j - offset][1] = j;
                } else {
                    offset++;
                }
            }
        }

        return ints;
    }


    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[][] sides = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            sides[prerequisite[0]][prerequisite[1]] = 1;
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(dfs(sides, query[0], query[1], numCourses));
        }

        return res;
    }

    private boolean dfs(int[][] sides, int numCourse, int target, int numCourses) {
        if (sides[numCourse][target] != 0) {
            return sides[numCourse][target] == 1;
        }

        for (int k = 0; k < numCourses; k++) {
            if (sides[numCourse][k] == 1 && dfs(sides, k, target, numCourses)) {
                sides[numCourse][target] = 1;
                return true;
            }
        }
        sides[numCourse][target] = -1;
        return false;
    }
}
