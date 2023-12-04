package com.github.morningwn.t0501_t1000.t0501_t0600.t0531_t0540;

import com.github.morningwn.prefab.Out;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;
import org.junit.Test;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/encode-and-decode-tinyurl/">535. TinyURL 的加密与解密</a>
 * <ul>
 * <li>{@link Difficulty#Medium}</li>
 * <li>{@link Topic#Design}</li>
 * <li>{@link Topic#HashTable}</li>
 * <li>{@link Topic#String}</li>
 * <li>{@link Topic#HashFunction}</li>
 * </ul>
 *
 * @author morningwn
 * @date 2019-09-22 14:16:42
 */
public class J0535 {

    @Test
    public void test() {
        Codec codec = new Codec();
        Out.println(codec.encode("https://leetcode.com/problems/design-tinyurl"));
        Out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
    }


    class Codec {

        final private HashMap<String, String> dicLtoS = new HashMap<String, String>();
        final private HashMap<String, String> dicStoL = new HashMap<String, String>();
        final private String dic = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {

            final String title = "http://tinyurl.com/";
            String tail = "";

            if (longUrl == null) {
                return null;
            } else if (dicLtoS.containsKey(longUrl)) {
                return title + dicLtoS.get(longUrl);
            } else {

                while (true) {
                    tail = "";
                    for (int i = 0; i < 6; i++) {
                        tail = tail + dic.charAt((int) (Math.random() * 56));
                    }

                    if (!dicLtoS.containsValue(tail)) {
                        break;
                    }
                }
                dicStoL.put(tail, longUrl);
                dicLtoS.put(longUrl, tail);
                return title + tail;
            }
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {

            if (shortUrl == null) {
                return null;
            } else {
                String tail = shortUrl.substring(19);
                if (dicStoL.containsKey(tail)) {
                    return dicStoL.get(tail);
                } else {
                    return null;
                }
            }

        }
    }

}
