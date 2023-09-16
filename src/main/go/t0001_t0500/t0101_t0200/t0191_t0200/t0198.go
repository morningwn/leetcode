package t0191_t0200

// 198. 打家劫舍
// https://leetcode.cn/problems/house-robber/description/

func rob(nums []int) int {
	prices := make([]int, len(nums)+2)

	for i, num := range nums {
		prices[i+2] = maxInt(prices[i+1], prices[i]+num)
	}

	return prices[len(nums)+1]
}

func maxInt(num1, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}
