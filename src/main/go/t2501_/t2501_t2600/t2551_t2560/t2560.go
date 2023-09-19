package t2551_t2560

import (
	"math"
)

// 2560. 打家劫舍 IV
// https://leetcode.cn/problems/house-robber-iv/description/

func minCapability(nums []int, k int) int {
	l, r := 0, math.MaxInt32

	for l <= r {
		m := (l + r) / 2
		if getCount(nums, m) >= k {
			r = m - 1
		} else {
			l = m + 1
		}
	}

	return l
}

func getCount(nums []int, max int) int {
	count := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] <= max {
			count++
			i++
		}
	}

	return count
}
