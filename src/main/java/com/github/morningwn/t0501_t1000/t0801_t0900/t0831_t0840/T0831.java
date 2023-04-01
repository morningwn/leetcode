package com.github.morningwn.t0501_t1000.t0801_t0900.t0831_t0840;

/**
 * <a href="https://leetcode.cn/problems/masking-personal-information/">831. 隐藏个人信息</a>
 *
 * @author morningwn
 * @create in 2023/4/1 16:49
 */
public class T0831 {
    public String maskPII(String s) {
        StringBuilder sb = new StringBuilder();
        int index = -1;
        char[] charArray = s.toCharArray();

        if ((index = s.indexOf("@")) != -1) {
            sb.append(charArray[0]);
            sb.append("*****");
            sb.append(s.substring(index - 1));
            return sb.toString().toLowerCase();
        } else {
            int numCount = 0;
            for (int i = s.length() - 1; i > -1; i--) {
                if (Character.isDigit(charArray[i])) {
                    numCount++;
                    if (numCount < 4) {
                        sb.append(charArray[i]);
                    } else if (numCount == 4) {
                        sb.append(charArray[i]);
                        sb.append('-');
                    } else {
                        sb.append('*');
                        if ((numCount - 4) % 3 == 0) {
                            sb.append('-');
                        }
                    }
                }
            }
            if (sb.charAt(sb.length() - 1) == '-') {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (numCount > 10) {
                sb.append('+');
            }

            return sb.reverse().toString();
        }

    }
}
