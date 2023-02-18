package com.github.morningwn.study;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 大数相乘
 *
 * @author morningwn
 * @create in 2023/2/17 16:16
 */
public class Multiply {

    @Test
    public void test() {
        String num1 = "1656753456345234545632452134253456345";
        String num2 = "123345367536534563456565633";
        System.out.println(multiply(num1, num2));

        System.out.println(new BigDecimal(num1).multiply( new BigDecimal(num2)));

    }

    public String multiply(String num1, String num2) {
        final int maxlen = 9;
        if (num1.length() > maxlen && num2.length() > maxlen) {
            int x = num1.length() - (num1.length() / 2);
            int y = num2.length() - (num2.length() / 2);

            String a = num1.substring(0, num1.length() / 2);
            String b = num1.substring(num1.length() / 2);

            String c = num2.substring(0, num2.length() / 2);
            String d = num2.substring(num2.length() / 2);

            // (a*10x + b) * (c*10y + d) = ac*10x*10y + ad*10x + bc*10y + bd;
            // (a*10x + b) * (c*10y + d) = ac*10x*10y + ((a*10x - b)(d - c*10y) + ac + bd) + bd;
            String ac = add10(multiply(a, c), x+y);
            String ad = add10(multiply(a, d), x);
            String bc = add10( multiply(b, c), y);
            String bd = multiply(b, d);
            return add(add(ac, ad), add(bc, bd));
        } else if (num1.length() <= maxlen && num2.length() > maxlen) {
            int y = num2.length() - (num2.length() / 2);
            String c = num2.substring(0, num2.length() / 2);
            String d = num2.substring(num2.length() / 2);

            // num1 * (c*10y + d) = num1*c*10y + num1*d;
            String num1c = add10(multiply(num1, c), y);
            String num1d = multiply(num1, d);
            return add(num1c, num1d);
        } else if (num1.length() > maxlen && num2.length() <= maxlen) {
            int x = num1.length() - (num1.length() / 2);

            String a = num1.substring(0, num1.length() / 2);
            String b = num1.substring(num1.length() / 2);

            // (a*10x + b) * num2 = a*num2*10x + b*num2;
            String anum2 = add10(multiply(a, num2), x);
            String bnum2 = multiply(b, num2);
            return add(anum2, bnum2);
        } else {
            return String.valueOf(Long.parseLong(num1) * Long.parseLong(num2));
        }
    }

    public String add10(String num, int n) {
        return num + "0".repeat(n);
    }

    public String div(String num1, String num2) {
        return "0";
    }

    public String add(String num1, String num2) {
        return new BigDecimal(num1).add(new BigDecimal(num2)).toString();
    }
}
