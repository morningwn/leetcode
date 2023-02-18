package cn.morningwn.t0001_t0500.t0201_t0300.t0251_t0260

import org.junit.Test

/**
 * <a href="https://leetcode-cn.com/problems/add-digits/">258. 各位相加</a>
 *
 * @author morningwn
 * @date Created in 2022/3/3 15:49
 */
class T0258 {

    @Test
    def test(): Unit = {
        val num = Int.MaxValue;
        println(addDigits(num))
    }

    def addDigits(num: Int): Int = {
        var res = num;
        while (res >= 10) {
            var tmp: Int = 0;
            while (res > 0) {
                tmp += res % 10;
                res /= 10;
            }
            res = tmp
        }
        return res
    }
}
