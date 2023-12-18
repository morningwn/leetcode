//
// 162. 寻找峰值
// https://leetcode.cn/problems/find-peak-element/
// Created by morningwn on 2023/12/18.
//

import Foundation

func findPeakElement(_ nums: [Int]) -> Int {
    if nums.count == 1 {
        return 0
    }
    if nums[0] > nums[1] {
        return 0
    }

    for i in 1..<nums.count - 1 {
        if nums[i - 1] < nums[i] && nums[i] < nums[i + 1] {
            return i
        }
    }

    if nums[nums.count - 1] > nums[nums.count - 2] {
        return nums.count - 1
    }

    return -1
}