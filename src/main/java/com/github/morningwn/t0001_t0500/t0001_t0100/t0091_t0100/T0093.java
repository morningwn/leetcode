package com.github.morningwn.t0001_t0500.t0001_t0100.t0091_t0100;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/restore-ip-addresses/">93. 复原 IP 地址</a>
 *
 * @author morningwn
 * @create in 2023/4/1 10:49
 */
public class T0093 {

    @Test
    public void test() {
        String s = "0000";
        List<String> ipAddresses = restoreIpAddresses(s);
        Out.print(ipAddresses);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ipAddressList = new ArrayList<>();
        getIp(new ArrayList<>(), s, 0, ipAddressList);
        return ipAddressList;
    }

    private void getIp(List<String> ipSegmentList, String s, int start, List<String> ipAddressList) {
        if (ipSegmentList.size() > 4) {
            return;
        }
        if (ipSegmentList.size() == 4) {
            if (s.length() == start) {
                ipAddressList.add(String.join(",", ipSegmentList));
            }
            return;
        }

        for (int i = 1; i < 4 && start + i <= s.length(); i++) {
            String segment = s.substring(start, start + i);
            if (check(segment)) {
                ipSegmentList.add(segment);
                getIp(ipSegmentList, s, start + i, ipAddressList);
                ipSegmentList.remove(ipSegmentList.size()-1);
            }
        }
    }

    private boolean check(String segment) {
        if (segment.length() == 1) {
            return true;
        } else if (segment.length() == 2) {
            return segment.charAt(0) != '0';
        } else if (segment.length() == 3) {
            return segment.charAt(0) != '0' && ((segment.charAt(0) - '0') * 100 + (segment.charAt(1) - '0') * 10 + (segment.charAt(2) - '0')) < 256;
        } else {
            return false;
        }
    }
}
