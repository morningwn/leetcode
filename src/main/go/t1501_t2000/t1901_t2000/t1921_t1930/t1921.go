package t1921_t1930

import (
	"sort"
)

// 1921. 消灭怪物的最大数量
// https://leetcode.cn/problems/eliminate-maximum-number-of-monsters/

func eliminateMaximum(dist []int, speed []int) int {
	worths := make([]int, len(dist))

	for i := range dist {
		worths[i] = getWorth(i, dist, speed)
	}

	count := 0
	sort.Sort(sort.IntSlice(worths))
	for i := range worths {
		if worths[i] <= i {
			return count
		}
		count++
	}

	return count
}

func getWorth(i int, dist, speed []int) int {
	if dist[i]%speed[i] > 0 {
		return 1 + dist[i]/speed[i]
	} else {
		return dist[i] / speed[i]
	}
}
