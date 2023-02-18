package com.github.morningwn.t0001_t0500.t0201_t0300.t0271_t0280;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * @author morningwn
 * @date Created in 2020/5/26 17:59
 */
public class T0278 {
    @Test
    public void test() {
        Out.println(Integer.toString(-32, 2));
        Out.println(Integer.toString(-32 >>> 1, 2));
//        Out.println(firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            Out.println(m);
            if (!isBadVersion(m)) {
                if (m + 1 < n && isBadVersion(m + 1)) {
                    return m + 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (m > 1 && isBadVersion(m - 1)) {
                    r = m - 1;
                } else {
                    return m;
                }
            }
        }

        return -1;
    }

    public boolean isBadVersion(int version) {
        int target = 1702766719;
        return version >= target;
    }
}
