//
// 2706. 购买两块巧克力
// https://leetcode.cn/problems/buy-two-chocolates/
// Created by morningwn on 2023-12-29 10:27:42.
//

import Foundation

class S2706 {

    func buyChoco(_ prices: [Int], _ money: Int) -> Int {
        var min1 = Int.max
        var min2 = Int.max
        
        for price in prices {
            if price < min1 {
                min2 = min1
                min1 = price
            } else if price < min2 {
                min2 = price
            }
        }
        if min1 + min2 > money {
            return money
        } else {
            return money - min1 - min2
        }
    }

}
