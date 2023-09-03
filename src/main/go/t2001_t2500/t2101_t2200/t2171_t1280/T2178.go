package t2171_t1280

// 2178. 拆分成最多数目的正偶数之和
// https://leetcode.cn/problems/maximum-split-of-positive-even-integers/description/

func maximumEvenSplit(finalSum int64) []int64 {
	var res []int64

	for i := int64(2); i <= finalSum; i += 2 {
		finalSum -= i
		res = append(res, i)
	}

	res[len(res)-1] += finalSum
	return res
}
