package com.github.morningwn.t1001_t1500.t1101_t1200.t1101_t1110;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/defanging-an-ip-address/">1108. IP 地址无效化</a>
 *
 * @author moringwn
 * @create in 2022/6/17 16:03
 */
public class T1108 {

    @Test
    public void test() {
        Out.println(defangIPaddr("2.1.1.1"));
        Out.println(defangIPaddr("255.100.50.0"));
    }

    public String defangIPaddr(String address) {

        StringBuffer output = new StringBuffer();

        for (int i = 0; i < 3; i++) {

            int index = address.indexOf(".");
            output.append(address, 0, index);
            output.append("[.]");
            address = address.substring(index + 1);

        }

        output.append(address);

        return output.toString();
    }
}

