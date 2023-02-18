package com.github.morningwn.t0001_t0500.t0201_t0300.t0271_t0280;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * 整数转换英文表示
 *
 * @author moringwn
 * @date 2021/10/11 上午9:58
 */
public class T0273 {
    private static final String[] NUMBERS = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    private static final String[] TEEN_NUMBERS = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TY_NUMBERS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private static final String HUNDRED = "Hundred";
    private static final String THOUSAND = "Thousand";
    private static final String MILLION = "Million";
    private static final String BILLION = "Billion";

    @Test
    public void test() {
        int num = 12;

        Out.println(numberToWords(num));
    }

    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();

        if (num == 0) {
            sb.append(NUMBERS[num]);
        }

        int tmp = 0;

        if (num >= 1000000000) {

            tmp = num / 1000000000;
            num = num % 1000000000;
            this.helper(tmp, sb);
            append(sb, BILLION);
        }

        if (num >= 1000000) {

            tmp = num / 1000000;
            num = num % 1000000;


            this.helper(tmp, sb);
            append(sb, MILLION);
        }

        if (num >= 1000) {
            tmp = num / 1000;
            num = num % 1000;
            this.helper(tmp, sb);
            append(sb, THOUSAND);
        }

        this.helper(num, sb);

        return sb.toString();
    }

    private void helper(int num, StringBuilder sb) {
        int tmp = 0;

        if (num >= 100) {
            tmp = num / 100;
            num = num % 100;
            append(sb, NUMBERS[tmp]);
            append(sb, HUNDRED);
        }

        if (num >= 20) {
            tmp = num / 10;
            num = num % 10;
            append(sb, TY_NUMBERS[tmp]);
        }

        if (num >= 10) {
            num = num % 10;
            append(sb, TEEN_NUMBERS[num]);
            num = 0;
        }

        if (num > 0) {
            append(sb, NUMBERS[num]);
        }
    }

    private void append(StringBuilder sb, String str) {
        if (sb.length() != 0) {
            sb.append(" ");
        }
        sb.append(str);
    }
}
