package prefab

import (
	"strconv"
	"strings"
)

func StringToInt(str string) int {
	num, _ := strconv.Atoi(str)
	return num
}

func StringToArray(str string) []int {
	str = str[1 : len(str)-1]
	split := strings.Split(str, ",")
	var res []int

	for _, s := range split {
		res = append(res, StringToInt(s))
	}
	return res
}

func StringTo2Array(str string, n int) [][]int {
	str = str[2 : len(str)-2]
	strs := strings.Split(str, "]")
	var res [][]int

	for _, s := range strs {
		s = strings.Trim(s, ",[,")
		s = strings.Trim(s, "[")
		split := strings.Split(s, ",")
		var arr []int
		for j := 0; j < n; j++ {
			arr = append(arr, StringToInt(split[j]))
		}
		res = append(res, arr)
	}

	return res
}
