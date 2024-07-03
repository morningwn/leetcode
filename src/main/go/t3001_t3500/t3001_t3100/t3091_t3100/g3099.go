package t3091_t3100

// 3099. 哈沙德数
// https://leetcode.cn/problems/harshad-number/description/

func sumOfTheDigitsOfHarshadNumber(x int) int {
	var tmpx = x
	var sum = 0

	for tmpx > 0 {
		sum += tmpx % 10
		tmpx /= 10
	}
	if x%sum == 0 {
		return sum
	} else {
		return -1
	}
}
