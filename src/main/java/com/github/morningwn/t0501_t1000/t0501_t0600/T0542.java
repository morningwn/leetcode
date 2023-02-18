package com.github.morningwn.t0501_t1000.t0501_t0600;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/4/15 15:32
 */
public class T0542 {

    @Test
    public void test() {

/*        0 0 0
        0 1 0
        0 0 0*/
//        int[][] matrix = {
//                { 0, 0, 0 },
//                { 0, 1, 0 },
//                { 0, 0, 0 }
//        };

//        int[][] matrix = {
//                {1,0,1,1,0,0,1,0,0,1},
//                {0,1,1,0,1,0,1,0,1,1},
//                {0,0,1,0,1,0,0,1,0,0},
//                {1,0,1,0,1,1,1,1,1,1},
//                {0,1,0,1,1,0,0,0,0,1},
//                {0,0,1,0,1,1,1,0,1,0},
//                {0,1,0,1,0,1,0,0,1,1},
//                {1,0,0,0,1,1,1,1,0,1},
//                {1,1,1,1,1,1,1,0,1,0},
//                {1,1,1,1,0,1,0,0,1,1}
//        };

        int[][] matrix = {
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
        };

        for (int[] i : updateMatrix(matrix)) {
            for (int j : i) {
                Out.print(j + "\t ");
            }

            Out.println();
        }
    }

    public int[][] updateMatrix(int[][] matrix) {

        //initialize variables
        //Number of rows in the matrix
        int len = matrix.length;
        //Number of columns in the matrix
        int column = matrix[0].length;
        //the result
        int[][] res = new int[len][column];
        //mark whether this position already has a value
        int[][] map = new int[len][column];
        //mark whether the loop can be ended. When there is no modification in this cycle, it means the end of the cycle
        boolean stop = false;

        //find the 0 in the matrix and mark it as processed
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    map[i][j] = 1;
                }
            }
        }

        while (!stop) {

            //If no changes have been made in the following, end the loop
            stop = true;

            //Update the distance of each item in the matrix
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < column; j++) {

                    //Temporary distance
                    int tmp = Integer.MAX_VALUE;

                    //find the distance in four directions, if it exist
                    //above
                    if (i - 1 >= 0 && map[i - 1][j] == 1) {
                        tmp = Math.min(tmp, res[i - 1][j] + 1);
                    }
                    //below
                    if (i + 1 < len && map[i + 1][j] == 1) {
                        tmp = Math.min(tmp, res[i + 1][j] + 1);
                    }
                    //left
                    if (j - 1 >= 0 && map[i][j - 1] == 1) {
                        tmp = Math.min(tmp, res[i][j - 1] + 1);
                    }
                    //right
                    if (j + 1 < column && map[i][j + 1] == 1) {
                        tmp = Math.min(tmp, res[i][j + 1] + 1);
                    }

                    //if the minimum distance exist, update it
                    if (tmp < Integer.MAX_VALUE) {

                        //if this item did not exist before, update the mark and the distance
                        //if this item already exist, go to the next step
                        if (map[i][j] == 0) {
                            stop = false;
                            res[i][j] = tmp;
                            map[i][j] = 1;
                        } else {

                            //if the distance is smaller, change it
                            if (res[i][j] > tmp) {
                                res[i][j] = tmp;
                                stop = false;
                            }
                        }
                    }
                }
            }
        }

        //return the result
        return res;
    }

}
