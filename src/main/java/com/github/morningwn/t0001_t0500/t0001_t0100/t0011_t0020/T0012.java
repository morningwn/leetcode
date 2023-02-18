package com.github.morningwn.t0001_t0500.t0001_t0100.t0011_t0020;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

public class T0012 {

    @Test
    public void test() {
        Out.println(intToRoman(3));        //III
        Out.println(intToRoman(4));        //IV
        Out.println(intToRoman(9));        //IX
        Out.println(intToRoman(58));        //LVIII
        Out.println(intToRoman(1994));    //MCMXCIV
    }

    public String intToRoman(int num) {
        if (num / 1000 >= 1) {
            return "M" + intToRoman(num - 1000);
        } else if (num / 900 == 1) {
            return "CM" + intToRoman(num - 900);
        } else if (num / 500 >= 1) {
            return "D" + intToRoman(num - 500);
        } else if (num / 400 == 1) {
            return "CD" + intToRoman(num - 400);
        } else if (num / 100 >= 1) {
            return "C" + intToRoman(num - 100);
        } else if (num / 90 == 1) {
            return "XC" + intToRoman(num - 90);
        } else if (num / 50 >= 1) {
            return "L" + intToRoman(num - 50);
        } else if (num / 40 == 1) {
            return "XL" + intToRoman(num - 40);
        } else if (num / 10 >= 1) {
            return "X" + intToRoman(num - 10);
        } else if (num / 9 == 1) {
            return "IX" + intToRoman(num - 9);
        } else if (num / 5 >= 1) {
            return "V" + intToRoman(num - 5);
        } else if (num / 4 == 1) {
            return "IV" + intToRoman(num - 4);
        } else if (num < 4 && num >= 1) {
            return "I" + intToRoman(num - 1);
        } else {
            return "";
        }
    }
}