package t3201_t3210

// 3206. 交替组 I
// https://leetcode.cn/problems/alternating-groups-i

func numberOfAlternatingGroups(colors []int) int {
    var groupCount = 0
	var length = len(colors)
	for index, color := range colors {
		var pre = (index - 1 + length) % length
		var next = (index + 1 + length) % length
		if colors[pre] != color && colors[next] != color && colors[pre] == colors[next] {
			groupCount++
		}
	}

	return groupCount
}