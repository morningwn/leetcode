package com.github.morningwn.t1501_t2000.t1701_t1800.t1791_t1800;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/design-authentication-manager/">1797. 设计一个验证系统</a>
 * @author morningwn
 * @create in 2023/2/9 21:53
 */
public class T1797 {

    class AuthenticationManager {
        private Map<String, Integer> cache;
        private int expire;

        public AuthenticationManager(int timeToLive) {
            this.expire = timeToLive;
            this.cache = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            cache.put(tokenId, currentTime);
        }

        public void renew(String tokenId, int currentTime) {
            Integer time = cache.get(tokenId);
            if (time != null && currentTime - time <= expire) {
                cache.put(tokenId, currentTime);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int count = 0;
            for (Map.Entry<String, Integer> entry : cache.entrySet()) {
                if (currentTime - entry.getValue() <= expire) {
                    count++;
                }
            }
            return count;
        }
    }
}
