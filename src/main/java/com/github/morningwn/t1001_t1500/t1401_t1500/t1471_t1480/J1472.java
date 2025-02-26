package com.github.morningwn.t1001_t1500.t1401_t1500.t1471_t1480;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/design-browser-history">1472. 设计浏览器历史记录</a>
 *
 * @author morningwn
 * @date 2025/2/26 11:15
 */
public class J1472 {

    @Test
    public void test() {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        Assert.assertEquals("facebook.com", browserHistory.back(1));
        Assert.assertEquals("google.com", browserHistory.back(1));
        Assert.assertEquals("facebook.com", browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        Assert.assertEquals("linkedin.com", browserHistory.forward(2));
        Assert.assertEquals("google.com", browserHistory.back(2));
        Assert.assertEquals("leetcode.com", browserHistory.back(7));
    }

    class BrowserHistory {
        private String[] history;
        private int curIndex;
        private int maxLength;

        public BrowserHistory(String homepage) {
            history = new String[5001];
            curIndex = 0;
            maxLength = 0;
            history[0] = homepage;
        }

        public void visit(String url) {
            history[++curIndex] = url;
            maxLength = curIndex;
        }

        public String back(int steps) {
            if (curIndex >= steps) {
                curIndex -= steps;
            } else {
                curIndex = 0;
            }
            return history[curIndex];
        }

        public String forward(int steps) {
            if (curIndex + steps <= maxLength) {
                curIndex += steps;
            } else {
                curIndex = maxLength;
            }
            return history[curIndex];
        }
    }

}
