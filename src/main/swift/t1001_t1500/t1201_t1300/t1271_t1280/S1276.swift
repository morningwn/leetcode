//
// 1276. 不浪费原料的汉堡制作方案
// https://leetcode.cn/problems/number-of-burgers-with-no-waste-of-ingredients/
// Created by morningwn on 2023-12-25 11:07:34.
//

import Foundation

class S1276 {
    func numOfBurgers(_ tomatoSlices: Int, _ cheeseSlices: Int) -> [Int] {
        if tomatoSlices % 2 != 0 {
            return [Int]()
        }
        
        var x = (tomatoSlices - 2 * cheeseSlices) / 2
        var y = cheeseSlices - x
        if x < 0 || y < 0 {
            return [Int]()
        }
        return [x, y]
    }
}
