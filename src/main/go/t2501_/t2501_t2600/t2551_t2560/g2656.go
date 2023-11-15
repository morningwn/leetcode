package t2551_t2560

// 2656. K 个元素的最大和
// https://leetcode.cn/problems/maximum-sum-with-exactly-k-elements/

func maximizeSum(nums []int, k int) int {
	maxNum := nums[0]
	for _, num := range nums {
		if num > maxNum {
			maxNum = num
		}
	}
	return maxNum*k + (((k - 1) * k) / 2)
}
