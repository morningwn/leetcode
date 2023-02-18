package cn.morningwn.t0501_t1000.t0901_t1000

import org.junit.Test

/**
 * <a href="https://leetcode-cn.com/problems/number-of-recent-calls/">933. 最近的请求次数</a>
 *
 * @author moringwn
 * @create in 2022/5/6 16:33
 */
class T0933 {

    @Test
    def test(): Unit = {
        var obj = new RecentCounter()
        println(obj.ping(1))
        println(obj.ping(100))
        println(obj.ping(3001))
        println(obj.ping(3002))
    }

    class RecentCounter() {
        private val queue = new Array[Int](10001);
        private var startIndex = 0;
        private var size = 0;

        def ping(t: Int): Int = {
            val start = t - 3000;
            queue(size) = t
            size += 1
            while (startIndex <= size && queue(startIndex) < start) {
                startIndex += 1
            }

            size - startIndex
        }

    }

}
