package t2591_t2600

// 2596. 检查骑士巡视方案
// https://leetcode.cn/problems/check-knight-tour-configuration/description/

func checkValidGrid(grid [][]int) bool {
	if grid[0][0] != 0 {
		return false
	}
	return checkValidStep(0, 0, 0, len(grid), grid)
}

func checkValidStep(row, col, step, n int, grid [][]int) bool {
	if step == n*n-1 {
		return true
	}
	if row-1 > -1 {
		if col-2 > -1 {
			if grid[row-1][col-2] == step+1 {
				return checkValidStep(row-1, col-2, step+1, n, grid)
			}
		}
		if col+2 < n {
			if grid[row-1][col+2] == step+1 {
				return checkValidStep(row-1, col+2, step+1, n, grid)
			}
		}
	}

	if row-2 > -1 {
		if col-1 > -1 {
			if grid[row-2][col-1] == step+1 {
				return checkValidStep(row-2, col-1, step+1, n, grid)
			}
		}
		if col+1 < n {
			if grid[row-2][col+1] == step+1 {
				return checkValidStep(row-2, col+1, step+1, n, grid)
			}
		}
	}

	if row+1 < n {
		if col-2 > -1 {
			if grid[row+1][col-2] == step+1 {
				return checkValidStep(row+1, col-2, step+1, n, grid)
			}
		}
		if col+2 < n {
			if grid[row+1][col+2] == step+1 {
				return checkValidStep(row+1, col+2, step+1, n, grid)
			}
		}
	}

	if row+2 < n {
		if col-1 > -1 {
			if grid[row+2][col-1] == step+1 {
				return checkValidStep(row+2, col-1, step+1, n, grid)
			}
		}
		if col+1 < n {
			if grid[row+2][col+1] == step+1 {
				return checkValidStep(row+2, col+1, step+1, n, grid)
			}
		}
	}

	return false
}
