package t1221_t1230

// 1222. 可以攻击国王的皇后
// https://leetcode.cn/problems/queens-that-can-attack-the-king/description/

func queensAttacktheKing(queens [][]int, king []int) [][]int {
	chessboard := [8][8]int{}

	for _, queen := range queens {
		chessboard[queen[0]][queen[1]] = 1
	}

	var attach [][]int
	flags := [8]bool{}

	for i := 1; i < 8; i++ {
		if king[1]+i < 8 && !flags[0] && chessboard[king[0]][king[1]+i] == 1 {
			attach = append(attach, []int{king[0], king[1] + i})
			flags[0] = true
		}
		if king[1]-i > -1 && !flags[1] && chessboard[king[0]][king[1]-i] == 1 {
			attach = append(attach, []int{king[0], king[1] - i})
			flags[1] = true
		}
		if king[0]+i < 8 && !flags[2] && chessboard[king[0]+i][king[1]] == 1 {
			attach = append(attach, []int{king[0] + i, king[1]})
			flags[2] = true
		}
		if king[0]-i > -1 && !flags[3] && chessboard[king[0]-i][king[1]] == 1 {
			attach = append(attach, []int{king[0] - i, king[1]})
			flags[3] = true
		}
		if king[0]+i < 8 {
			if king[1]+i < 8 && !flags[4] && chessboard[king[0]+i][king[1]+i] == 1 {
				attach = append(attach, []int{king[0] + i, king[1] + i})
				flags[4] = true
			}

			if king[1]-i > -1 && !flags[5] && chessboard[king[0]+i][king[1]-i] == 1 {
				attach = append(attach, []int{king[0] + i, king[1] - i})
				flags[5] = true
			}
		}
		if king[0]-i > -1 {
			if king[1]+i < 8 && !flags[6] && chessboard[king[0]-i][king[1]+i] == 1 {
				attach = append(attach, []int{king[0] - i, king[1] + i})
				flags[6] = true
			}

			if king[1]-i > -1 && !flags[7] && chessboard[king[0]-i][king[1]-i] == 1 {
				attach = append(attach, []int{king[0] - i, king[1] - i})
				flags[7] = true
			}
		}
	}

	return attach
}
