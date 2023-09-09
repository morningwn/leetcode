package com.github.morningwn.t0001_t0500.t0201_t0300.t0201_t0210;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/course-schedule/">207. 课程表</a>
 *
 * @author morningwn
 * @date Created in 2023/9/9 14:32
 */
public class T0207 {

    @Test
    public void test() {
        int numCourses = 0;
        int[][] prerequisites = {};

        numCourses = 2;
        prerequisites = new int[][]{{1, 0}};
        Assert.assertTrue("1", canFinish(numCourses, prerequisites));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = 1;
        }

        for (int i = 0; i < numCourses; i++) {
            boolean dfs = dfs(visited, graph, i, numCourses);
            if (!dfs) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int[] visited, int[][] graph, int i, int numCourses) {
        if (visited[i] == 1) {
            return true;
        } else if (visited[i] == -1) {
            return false;
        }
        visited[i] = -1;
        for (int j = 0; j < numCourses; j++) {
            if (graph[i][j] == 1) {
                if (visited[j] != 1) {
                    if (!dfs(visited, graph, j, numCourses)) {
                        return false;
                    }
                }
            }
        }
        visited[i] = 1;
        return true;
    }
}
