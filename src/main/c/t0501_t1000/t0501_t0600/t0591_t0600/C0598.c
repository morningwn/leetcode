/**
 * 598. 范围求和 II
 * <link>https://leetcode-cn.com/problems/range-addition-ii/</link>
 */
#include <stdio.h>

int maxCount(int m, int n, int **ops, int opsSize, int *opsColSize) {

    unsigned int line = m;
    unsigned int row = n;

    for (int i = 0; i < opsSize; ++i) {
        if (line > ops[i][0]) {
            line = ops[i][0];
        }
        if (row > ops[i][1]) {
            row = ops[i][1];
        }
    }

    return line * row;
}

int main() {


    return 0;
}
