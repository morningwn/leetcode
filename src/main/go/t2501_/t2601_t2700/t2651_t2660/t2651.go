package t2651_t2660

// 2651. 计算列车到站时间
// https://leetcode.cn/problems/calculate-delayed-arrival-time/

func findDelayedArrivalTime(arrivalTime int, delayedTime int) int {
	return (arrivalTime + delayedTime) % 24
}
