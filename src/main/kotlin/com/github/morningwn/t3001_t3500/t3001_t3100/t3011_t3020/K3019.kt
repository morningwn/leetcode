package com.github.morningwn.t3001_t3500.t3001_t3100.t3011_t3020

/**
 * <a href="https://leetcode.cn/problems/number-of-changing-keys">3019. 按键变更的次数</a>
 *
 * @author morningwn
 * @date 2025-01-07 15:59:24
 */
class K3019 {
    fun countKeyChanges(s: String): Int {
        var i = 1
        var count = 0
        val def = 'a' - 'A'
        while (i < s.length) {
            if (s[i] != s[i - 1]
                && s[i] != s[i - 1] + def
                && s[i] + def != s[i - 1]
            ) {
                count++
            }
            i++
        }

        return count
    }


}