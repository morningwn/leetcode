package cn.morningwn.t0501_t1000.t0901_t1000

import org.junit.Test

import scala.util.control._

/**
 * <a href="https://leetcode.cn/problems/delete-columns-to-make-sorted/">944. 删列造序</a>
 *
 * @author moringwn
 * @create in 2022/5/12 10:49
 */
class T0944 {

    @Test
    def test(): Unit = {
        val strs: Array[String] = Array("cba", "daf", "ghi")

        println(minDeletionSize(strs))
    }

    def minDeletionSize(strs: Array[String]): Int = {
        val length: Int = strs(0).length
        val n: Int = strs.length
        var count: Int = 0
        val loop = new Breaks

        for (i <- 0 until length) {
            var pre: Char = strs(0).charAt(i);
            loop.breakable {
                for (j <- 1 until n) {
                    val cur: Char = strs(j).charAt(i)
                    if (cur < pre) {
                        count += 1
                        loop.break
                    } else {
                        pre = cur
                    }
                }
            }

        }

        count
    }

}
