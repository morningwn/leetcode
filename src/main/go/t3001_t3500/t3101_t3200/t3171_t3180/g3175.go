package t3171t3180

// 3175. 找到连续赢 K 场比赛的第一位玩家
// https://leetcode.cn/problems/find-the-first-player-to-win-k-games-in-a-row

func findWinningPlayer(skills []int, k int) int {
	winningCount := -1
	winningIndex := 0

	for index, skill := range skills {
		if skill > skills[winningIndex] {
			winningCount = 0
			winningIndex = index
		}
		winningCount++
		if winningCount >= k {
			return winningIndex
		}
	}

	return winningIndex
}
