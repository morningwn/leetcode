package t2541_t2550

// 2544. 交替数字和
// https://leetcode.cn/problems/alternating-digit-sum/

func alternateDigitSum(n int) int {
	var offset = 1000000000
	var flag = false
	var bit = 1
	var res = 0
	for n > 0 {
		if n/offset != 0 {
			flag = true
		}
		res += (n / offset) * bit
		n = n % offset
		offset /= 10
		if flag {
			bit *= -1
		}
	}
	return res
}
