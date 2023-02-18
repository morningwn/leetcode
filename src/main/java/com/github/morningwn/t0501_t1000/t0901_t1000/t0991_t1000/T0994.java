package com.github.morningwn.t0501_t1000.t0901_t1000.t0991_t1000;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T0994 {

    @Test
    public void test() {

//        int[][] gird = {{2,1,1},{1,1,0},{0,1,1}};
//        int[][] gird = {{2,1,1},{0,1,1},{1,0,1}};
//        int[][] gird = {{0,2}};
//        int[][] gird = {{0}};
        int[][] gird = {{0, 0, 0}, {0, 1, 2}, {2, 2, 2}};
        Out.println(orangesRotting(gird));
    }

    public int orangesRotting(int[][] grid) {

        //判断是否已经将可以感染的苹果都感染完
        boolean stop = false;

        //计算进行了几轮感染
        int count = 0;

        //暂时存储查询到的还未感染别的苹果的腐烂苹果
        List<int[]> stoke = new ArrayList<>();

        //存储当前已经感染过别的苹果的腐烂的苹果，避免重复
        int[][] map = new int[grid.length][grid[0].length];

        //一直循环，直到把所有能够感染的苹果都给感染完
        while (!stop) {
            stop = true;

            //循环查询所有还未感染过别的苹果的腐烂苹果
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {

                    //如果还未感染过别的苹果就将其存储在stock内
                    if (grid[i][j] == 2 && map[i][j] != 1) {
                        stoke.add(new int[]{i, j});
                        map[i][j] = 1;
                        //如果还存在尚未感染的苹果就证明可能还需要继续进行循环
                    } else if (grid[i][j] == 1) {
                        stop = false;
                    }
                }
            }

            //将次数加一
            count++;

            //如果stock为空，证明已经没有可以去感染别的苹果的腐烂苹果了，结束循环
            if (stoke.isEmpty()) {
                break;
            }

            //将上面查询到的腐烂苹果周围的苹果感染
            for (int[] i : stoke) {

//                Out.print(i[0] + "\t " + i[1] + "\t  ||");

                //上面
                if (i[0] < grid.length - 1) {
                    grid[i[0] + 1][i[1]] = grid[i[0] + 1][i[1]] == 0 ? 0 : 2;
                }

                //下面
                if (i[0] > 0) {
                    grid[i[0] - 1][i[1]] = grid[i[0] - 1][i[1]] == 0 ? 0 : 2;
                }

                //左侧
                if (i[1] < grid[0].length - 1) {
                    grid[i[0]][i[1] + 1] = grid[i[0]][i[1] + 1] == 0 ? 0 : 2;
                }

                //右侧
                if (i[1] > 0) {
                    grid[i[0]][i[1] - 1] = grid[i[0]][i[1] - 1] == 0 ? 0 : 2;
                }
            }

//            Out.println( stoke );

            //清空stock进行下一轮循环
            stoke.clear();
        }


        //如果将所有能感染的苹果都感染过了
        //但是仍然存在尚未感染的苹果，证明不能把所有的苹果都感染，返回-1
        //否则返回count-1，因为计数的时候多算了一次，要减去
        if (stop) {
            return count - 1;
        } else {
            return -1;
        }
    }

}
