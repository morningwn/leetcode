package t3181t3190

// 3185. 构成整天的下标对数目 II
// https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-ii

func countCompleteDayPairs(hours []int) int64 {
	hourCount := make([]int64, 24, 24)
	count := int64(0)
	for _, hour := range hours {
		count += hourCount[(24-hour%24)%24]
		hourCount[hour%24]++
	}
	return count
}
