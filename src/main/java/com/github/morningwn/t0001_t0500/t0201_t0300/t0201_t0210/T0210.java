package com.github.morningwn.t0001_t0500.t0201_t0300.t0201_t0210;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author morningwn
 * @description: 课程表 II
 * @date Created in 2020/5/17 20:41
 * @version: 1.0
 */
public class T0210 {

    @Test
    public void test() {
        int[][] prerequisites = {};

        Out.println(findOrder(1, prerequisites).length);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        Queue<List<Integer>> queue = new LinkedList<>();

        for (int[] prerequisite : prerequisites) {
            int size = queue.size();

            if (size == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(prerequisite[1]);
                tmp.add(prerequisite[0]);
                queue.offer(tmp);
            } else {
                Out.println(queue + "\t " + prerequisite[0] + "\t" + prerequisite[1]);
                for (int i = 0; i < size; i++) {
                    List<Integer> tmp = queue.poll();
                    int index0 = tmp.indexOf(prerequisite[0]);
                    int index1 = tmp.indexOf(prerequisite[1]);

                    if (index0 != -1 && index1 != -1) {
                        if (index0 > index1) {
                            queue.offer(tmp);
                        }
                    } else if (index0 == -1 && index1 != -1) {
                        for (int j = index1 + 1; j <= tmp.size(); j++) {
                            List<Integer> t = new ArrayList<>(tmp);
                            t.add(j, prerequisite[0]);
                            queue.offer(t);
                        }
                    } else if (index0 != -1 && index1 == -1) {
                        for (int j = 0; j < index0; j++) {
                            List<Integer> t = new ArrayList<>(tmp);
                            t.add(j, prerequisite[1]);
                            queue.offer(t);
                        }
                    } else {
                        List<Integer> t = new ArrayList<>(tmp);
                        t.add(prerequisite[1]);
                        t.add(prerequisite[0]);
                        queue.offer(t);
                    }
                }
            }
        }
        if (queue.size() > 0) {
            int[] res = new int[numCourses];
            List<Integer> tmp = queue.poll();
            for (int i = 0; i < numCourses; i++) {
                res[i] = tmp.get(i);
            }
            return res;
        } else {
            return new int[0];
        }
    }

}
