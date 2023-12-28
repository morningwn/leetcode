//
// 2660. 保龄球游戏的获胜者
// https://leetcode.cn/problems/determine-the-winner-of-a-bowling-game/
// Created by morningwn on 2023-12-27 10:29:36.
//

import Foundation

class S2660 {

    func isWinner(_ player1: [Int], _ player2: [Int]) -> Int {
        let score1 = getScore(player1)
        let score2 = getScore(player2)
        
        if score1 > score2 {
            return 1
        } else if score1 == score2 {
            return 0
        } else {
            return 2
        }
    }
    
    func getScore(_ player:[Int]) -> Int {
        var score = 0
        var doubleScoreFlag = 0
        for x in player {
            if doubleScoreFlag != 0 {
                score += 2 * x
                doubleScoreFlag-=1
            } else {
                score += x
            }
            if x == 10 {
                doubleScoreFlag = 2
            }
        }
        
        return score
    }

}
