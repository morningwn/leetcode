package com.github.morningwn.t2001_t2500.t2301_t2400.t2301_t2310;

import com.github.morningwn.prefab.FormatInput;
import com.github.morningwn.prefab.Out;
import org.junit.Test;


/**
 * <a href="https://leetcode.cn/problems/minimum-path-cost-in-a-grid/">2304. 网格中的最小路径代价</a>
 *
 * @author morningwn
 * @date
 */
public class J2304 {

    @Test
    public void test() {
        int[][] grid = {};
        int[][] moveCost = {};

        grid = FormatInput.stringTo2Array("[[5,3],[4,0],[2,1]]", 2);
        moveCost = FormatInput.stringTo2Array("[[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]", 2);
        Out.println(minPathCost(grid, moveCost));  // 17

        grid = FormatInput.stringTo2Array("[[5,1,2],[4,0,3]]", 3);
        moveCost = FormatInput.stringTo2Array("[[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]]", 3);
        Out.println(minPathCost(grid, moveCost));  // 6

        grid = FormatInput.stringTo2Array("[[28,35,29,5,13,17,18,23,14],[30,15,12,27,2,26,25,19,7],[1,16,34,21,9,3,20,24,8],[4,33,22,11,31,0,6,10,32]]", 9);
        moveCost = FormatInput.stringTo2Array("[[87,46,11,33,55,26,26,56,23],[77,56,72,49,35,18,37,66,37],[54,40,62,1,64,49,95,81,77],[80,7,76,71,91,67,75,84,52],[65,11,13,15,9,34,10,98,20],[1,95,100,61,33,47,28,100,44],[39,56,94,7,64,91,66,34,70],[37,99,62,7,23,78,74,89,97],[84,41,63,42,84,15,46,31,11],[60,36,27,25,37,18,4,90,43],[35,83,90,37,91,27,61,99,53],[85,2,98,99,67,70,38,91,68],[66,46,7,99,26,81,95,51,51],[41,96,66,84,61,73,78,28,63],[38,34,49,55,35,29,93,5,28],[3,30,80,20,23,10,93,40,33],[8,86,47,15,45,84,47,19,58],[72,5,76,82,60,50,13,74,38],[4,8,25,38,29,4,60,81,21],[65,50,74,32,9,47,71,55,14],[90,30,92,51,45,51,4,85,22],[30,56,1,45,63,72,91,73,60],[51,61,53,49,44,99,11,5,3],[24,54,91,11,5,30,50,89,44],[87,97,46,92,93,41,64,73,15],[94,76,90,80,30,9,88,8,33],[50,34,4,63,49,90,46,55,16],[10,46,80,21,97,69,70,85,31],[10,66,74,43,65,45,85,34,91],[82,26,77,10,2,5,89,39,4],[80,70,89,73,54,61,100,89,23],[30,66,80,51,3,34,92,100,63],[74,15,4,33,37,3,87,76,92],[44,43,77,99,27,1,23,10,8],[8,74,17,35,31,84,97,98,34],[99,9,28,43,55,39,93,64,93]]", 9);
        Out.println(minPathCost(grid, moveCost));   // 59
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] costs = new int[m][n];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            costs[0][i] = grid[0][i];
        }

        for (int i = 0; i < m - 1; i++) {
            res = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                costs[i + 1][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    costs[i + 1][j] = Math.min(costs[i + 1][j], costs[i][k] + moveCost[grid[i][k]][j]);
                }
                costs[i + 1][j] += grid[i + 1][j];
                res = Math.min(res, costs[i + 1][j]);
            }
        }
        return res;
    }
}
