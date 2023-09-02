package t2231_t2240

// 2240. 买钢笔和铅笔的方案数
// https://leetcode.cn/problems/number-of-ways-to-buy-pens-and-pencils/
func waysToBuyPensPencils(total int, cost1 int, cost2 int) int64 {
	if cost1 < cost2 {
		return waysToBuyPensPencils(total, cost2, cost1)
	}
	var res, cnt int
	for cnt*cost1 <= total {
		res += (total-cnt*cost1)/cost2 + 1
		cnt++
	}
	return int64(res)
}
