package com.github.morningwn.t1001_t1500.t1401_t1500.t1461_t1470;

import com.github.morningwn.prefab.FormatInput;
import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * <a href="https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/">1466. 重新规划路线</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#DepthFirstSearch}</li>
 * <li>{@link Topic#BreadthFirstSearch}</li>
 * <li>{@link Topic#Graph}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2023-12-07 16:02:38
 */
public class J1466 {

    @Test
    public void test() {
        int[][] connections;
        int n;

        n = 6;
        connections = FormatInput.stringTo2Array("[[0,1],[1,3],[2,3],[4,0],[4,5]]", 2);
        Out.println(minReorder(n, connections));
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> countMap = new HashMap<>();

        for (int[] connection : connections) {
            map.computeIfAbsent(connection[1], k -> new HashSet<>()).add(connection[0]);
            countMap.computeIfAbsent(connection[0], k -> new HashSet<>()).add(connection[1]);
        }
        return getRevCount(map, countMap, 0, n);
    }

    private int getRevCount(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> countMap, int curNode, int n) {
        if (curNode >= n || map.isEmpty()) {
            return 0;
        }
        int count = 0;

        if (map.containsKey(curNode)) {
            for (Integer nextNode : map.get(curNode)) {
                if (countMap.containsKey(nextNode)) {
                    countMap.get(nextNode).remove(curNode);
                }
                count += getRevCount(map, countMap, nextNode, n);
            }
        }
        if (countMap.containsKey(curNode)) {
            for (Integer nextNode : countMap.get(curNode)) {
                if (map.containsKey(nextNode)) {
                    map.get(nextNode).remove(curNode);
                }
                count += 1 + getRevCount(map, countMap, nextNode, n);
            }
        }
        return count;
    }
}
