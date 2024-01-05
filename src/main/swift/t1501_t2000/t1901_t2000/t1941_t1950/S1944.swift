//
// 1944. 队列中可以看到的人数
// https://leetcode.cn/problems/number-of-visible-people-in-a-queue/
// Created by morningwn on 2024-01-05 16:50:29.
//

import Foundation

class S1944 {
    
    func canSeePersonsCount(_ heights: [Int]) -> [Int] {
        var seeCounts = [Int](repeating:0,count: heights.count)
        var stack = [Int]()
        
        for i in stride(from: heights.count - 1, to: -1, by: -1) {
            while !stack.isEmpty && stack.last! <= heights[i] {
                stack.removeLast()
                seeCounts[i] += 1
            }
            if !stack.isEmpty {
                seeCounts[i] += 1
            }
            stack.append(heights[i])
        }
        return seeCounts
    }

}
