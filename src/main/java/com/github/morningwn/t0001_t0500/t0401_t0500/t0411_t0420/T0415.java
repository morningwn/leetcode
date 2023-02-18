package com.github.morningwn.t0001_t0500.t0401_t0500.t0411_t0420;


public class T0415 {

    public T0415() {

    }

    public String addStrings(String num1, String num2) {

        //结果长度为num1和num2较长的那个数的长度再加一
        int len = Math.max(num1.length(), num2.length()) + 1;

        //初始化结果和进位存储的地方
        String sum = "";
        int next = 0;

        for (int i = 0; i < len; i++) {

            //在计算的位数都小于两数的情况
            if (i < num1.length() && i < num2.length()) {

                //截取计算的这两个数，求和，若有进位则将进位的值存储在next中，用于下一轮计算
                int number1 = num1.charAt(num1.length() - i - 1) - '0';
                int number2 = num2.charAt(num2.length() - i - 1) - '0';

//                int number1 = Integer.parseInt( num1.substring( num1.length()-1-i, num1.length()-i ) );
//                int number2 = Integer.parseInt( num2.substring( num2.length()-1-i, num2.length()-i ) );
                int tmp = (number1 + number2 + next) % 10;
                next = (number1 + number2 + next) / 10;

                //将本轮求取的结果添加在结果中
                sum = tmp + sum;

                //计算的位置已经超过了num2的情况
            } else if (i < num1.length() && i >= num2.length()) {

                //因为存在连续进位的情况，所以这里使用了while循环
                while (next == 1) {

                    //初始化number1并截取到相应的值
                    int number1 = 0;
                    if (i < num1.length()) {
                        number1 = Integer.parseInt(num1.substring(num1.length() - 1 - i, num1.length() - i));
                    }

                    //对相应的值进行计算
                    int tmp = (number1 + next) % 10;
                    next = (number1 + next) / 10;

                    //添加
                    sum = tmp + sum;

                    //将i加一
                    i++;
                }

                //如果在循环结束后仍有更高位没有参加运算，直接将其添加在结果中就OK了
                if (i < num1.length()) {
                    sum = num1.substring(0, num1.length() - i) + sum;
                }

                //结束循环
                break;

                //计算的位置已经超过了num2的情况
            } else if (i >= num1.length() && i < num2.length()) {

                //和上面的情况类似，不再多说
                while (next == 1) {
                    int number2 = 0;
                    if (i < num2.length()) {
                        number2 = Integer.parseInt(num2.substring(num2.length() - 1 - i, num2.length() - i));
                    }

                    int tmp = (number2 + next) % 10;
                    next = (number2 + next) / 10;

                    sum = tmp + sum;
                    i++;
                }
                if (i < num2.length()) {
                    sum = num2.substring(0, num2.length() - i) + sum;
                }

                break;

                //计算到最后，有进位的情况
            } else if (next == 1) {
                sum = next + sum;
            }

        }

        return sum;

    }

    public void test() {
        T0415 t0415 = new T0415();
    }
}
