import Foundation

// 1394. 找出幸运整数
// https://leetcode.cn/problems/find-lucky-integer-in-an-array

@Test func name() async throws {
    findLucky([1,2,2,3,4]).assertEqual(2)
}

    func findLucky(_ arr: [Int]) -> Int {
        var countMap:[Int:Int] = [:]
        for a in arr {
            if let count = countMap[a] {
                countMap[a] = count+1
            } else {
                countMap[a] = 1
            }
        }

        var maxLucky = -1

        for (k, v) in countMap {
            if k == v && maxLucky < k {
                maxLucky = k
            }
        }

        return maxLucky
    }
