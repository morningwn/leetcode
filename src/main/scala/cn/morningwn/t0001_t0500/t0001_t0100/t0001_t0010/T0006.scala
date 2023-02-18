package cn.morningwn.t0001_t0500.t0001_t0100.t0001_t0010

import org.junit.Test


/**
 * <a href="https://leetcode-cn.com/problems/zigzag-conversion/">6. Z 字形变换</a>
 *
 * @author morningwn
 * @date Created in 2022/3/1 18:35
 */
class T0006 {

    @Test
    def test(): Unit = {
        val s = "PAYPALISHIRING"
        println(convert(s, 3))
    }

    def convert(s: String, numRows: Int): String = {

        if (numRows == 1) {
            return s
        }
        val rows = new Array[StringBuilder](numRows)
        for (i <- 0 until numRows) {
            rows(i) = new StringBuilder()
        }

        var count: Int = 0
        var i: Int = 1
        var j: Int = 1

        while (count < s.length) {
            if (i % (numRows - 1) == 1 || numRows == 2) {
                rows(j - 1).append(s.charAt(count))
                count += 1
                if (j + 1 <= numRows) {
                    j += 1
                } else {
                    i += 1
                    j -= 1
                }
            } else {
                rows(j - 1).append(s.charAt(count))
                count += 1
                i += 1
                j -= 1
            }
        }
        val sb: StringBuilder = new StringBuilder();
        for (row <- rows) {
            sb.append(row.toString())
        }

        sb.toString()
    }
}
