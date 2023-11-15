/**
 * 495. 提莫攻击
 * <link>https://leetcode-cn.com/problems/teemo-attacking/</link>
 */

#include <stdio.h>

int findPoisonedDuration(int *timeSeries, int timeSeriesSize, int duration) {
    int res = 0;
    int position = 0;

    for (int i = 0; i < timeSeriesSize; ++i) {
        if (position > timeSeries[i]) {
            res -= (position - timeSeries[i]);
        }
        res += duration;
        position = duration + timeSeries[i];
    }

    return res;
}

int main() {
    int timeSeries[] = {1, 2};
    int timeSeriesSize = 2;
    int duration = 2;

    printf("%d", findPoisonedDuration(timeSeries, timeSeriesSize, duration));

    return 0;
}
