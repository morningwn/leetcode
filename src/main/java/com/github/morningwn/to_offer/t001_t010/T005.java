package com.github.morningwn.to_offer.t001_t010;

/**
 * @author morningwn
 * @description: 替换空格
 * @date Created in 2020/6/30 23:12
 * @version: 1.0
 */
public class T005 {

    public T005() {

    }

    /**
     * @param s
     * @return java.lang.String
     * @author morningwn
     * @date 2020/6/30 23:12
     * @description: 替换空格，数组遍历法
     */
    public String replaceSpace(String s) {
        char[] characters = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char character : characters) {
            if (' ' == character) {
                sb.append("%20");
            } else {
                sb.append(character);
            }
        }

        return sb.toString();
    }
}
