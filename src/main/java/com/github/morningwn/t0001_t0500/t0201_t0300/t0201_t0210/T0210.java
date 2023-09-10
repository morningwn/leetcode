package com.github.morningwn.t0001_t0500.t0201_t0300.t0201_t0210;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/course-schedule-ii/">210. 课程表 II</a>
 *
 * @author morningwn
 * @date Created in 2023/9/10 20:41
 */
public class T0210 {

    @Test
    public void test() {
        int[][] prerequisites = {{1, 0}};

        Out.println(findOrder(2, prerequisites));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];
        List<Integer> res = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = 1;
        }

        for (int i = 0; i < numCourses; i++) {
            boolean dfs = dfs(visited, graph, i, numCourses, res);
            if (!dfs) {
                return new int[]{};
            }
        }

        int[] orders = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            orders[i] = res.get(i);
        }
        return orders;
    }

    public boolean dfs(int[] visited, int[][] graph, int i, int numCourses, List<Integer> order) {
        if (visited[i] == 1) {
            return true;
        } else if (visited[i] == -1) {
            return false;
        }
        visited[i] = -1;
        for (int j = 0; j < numCourses; j++) {
            if (graph[i][j] == 1) {
                if (visited[j] != 1) {
                    if (!dfs(visited, graph, j, numCourses, order)) {
                        return false;
                    }
                }
            }
        }
        order.add(i);
        visited[i] = 1;
        return true;
    }
}
