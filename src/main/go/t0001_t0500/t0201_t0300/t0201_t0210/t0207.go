package t0201_t0210

// 207. 课程表
// https://leetcode.cn/problems/course-schedule/

func canFinish(numCourses int, prerequisites [][]int) bool {
	prerequisiteMap := make([][]int, numCourses)
	for i := 0; i < numCourses; i++ {
		prerequisiteMap[i] = make([]int, numCourses)
	}

	for _, prerequisite := range prerequisites {
		prerequisiteMap[prerequisite[0]][prerequisite[1]] = 1
	}

	flags := make([]bool, numCourses)
	exit := false
	finish := false
	for !exit {
		exit = true
		finish = true
		for i, flag := range flags {
			if !flag {
				flag = true
				for j := 0; j < numCourses; j++ {
					if prerequisiteMap[i][j] == 1 && !flags[j] {
						flag = false
						break
					}
				}
				if flag {
					flags[i] = true
					exit = false
				} else {
					finish = false
				}
			}
		}
	}

	return finish
}
