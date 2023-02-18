package com.github.morningwn.t1001_t1500.t1101_t1200.t1121_t1130;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/shortest-path-with-alternating-colors/">1129. 颜色交替的最短路径</a>
 *
 * @author morningwn
 * @create in 2023/2/2 10:54
 */
public class T1129 {

//    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
//        int[][] redGraph = new int[n][n];
//        int[][] blueGraph = new int[n][n];
////        Set[] redGraph = new Set[n];
////        Set[] blueGraph = new Set[n];
//
//        for (int[] redEdge : redEdges) {
//            redGraph[redEdge[0]][redEdge[1]] = 1;
//            redGraph[redEdge[1]][redEdge[0]] = 1;
//        }
//        for (int[] blueEdge : blueEdges) {
//            blueGraph[blueEdge[0]][blueEdge[1]] = 1;
//            blueGraph[blueEdge[1]][blueEdge[0]] = 1;
//        }
//
//        int[] res = new int[n];
//
//        for (int i = 1; i < n; i++) {
//            List<Queue<Integer>> list = new ArrayList<>();
//            Queue<Integer> queueZero = new ArrayDeque<>();
//            queueZero.add(0);
//            list.add(queueZero);
//            do {
//                int size = list.size();
//                for (int j = 0; j < size; j++) {
//                    int curNode = list.get(j).peek();
//                    for (int k = 0; k < n; k++) {
//                        if (curNode == 0) {
//                            redGraph[]
//                        } else if (curNode > 0) {
//
//                        } else {
//
//                        }
//                    }
//                }
//            } while (!list.isEmpty());
//        }
//        return res;
//    }
}
