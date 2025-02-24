package com.github.morningwn.t1501_t2000.t1601_t1700.t1651_t1660;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/design-an-ordered-stream">1656. 设计有序流</a>
 *
 * @author morningwn
 * @date 2025-02-24 11:02:56
 */
public class J1656 {
    class OrderedStream {
        private String[] stream;
        private Integer ptr;

        public OrderedStream(int n) {
            stream = new String[n];
            ptr = 0;
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey - 1] = value;
            if (ptr != idKey - 1) {
                return Collections.emptyList();
            }
            List<String> list = new ArrayList<>();
            while (ptr < stream.length && stream[ptr] != null) {
                list.add(stream[ptr++]);
            }
            return list;
        }
    }


}