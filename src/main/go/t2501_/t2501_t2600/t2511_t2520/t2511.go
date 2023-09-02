package t2511_t2520

// 2511. 最多可以摧毁的敌人城堡数目
// https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/
func captureForts(forts []int) int {
	maxCount := 0
	preIndex := 0

	for i := range forts {
		if forts[i] == 0 {
			continue
		} else {
			if forts[preIndex] != 0 && forts[i] != forts[preIndex] {
				maxCount = max(maxCount, i-preIndex)
			}
			preIndex = i
		}
	}
	return maxCount
}

func max(n1, n2 int) int {
	if n1 > n2 {
		return n1
	}

	return n2
}
