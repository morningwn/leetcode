package com.github.morningwn.t0001_t0500.t0301_t0400.t0391_t0400;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.github.morningwn.prefab.Out;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * <a href"https://leetcode.cn/problems/evaluate-division/">399. 除法求值</a>
 *
 * @author moringwn
 * @date 2025/01/08 上午11:21
 */
public class J0399 {

    @Test
    public void test() {
        List<List<String>> equations = JSON.parseObject("[[\"a\",\"b\"],[\"b\",\"c\"]]", new TypeReference<List<List<String>>>() {
        });
        double[] values = {2.0, 3.0};
        List<List<String>> queries = JSON.parseObject("[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]", new TypeReference<List<List<String>>>() {
        });

        double[] doubles = calcEquation(equations, values, queries);
        double[] res = {6.0,0.5,-1.0,1.0,-1.0};
        Assert.assertArrayEquals(res, doubles, 0);
        Out.println(doubles);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            map.computeIfAbsent(equation.get(0), k -> new HashMap<>()).put(equation.get(1), values[i]);
            map.computeIfAbsent(equation.get(1), k -> new HashMap<>()).put(equation.get(0), 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Double v = get(map, query.get(0), query.get(1), new HashSet<>());
            if (v == null) {
                v = -1.0;
            }
            res[i] = v;
        }
        return res;
    }

    private Double get(Map<String, Map<String, Double>> map, String cur, String target, Set<String> visited) {

        Map<String, Double> curMap = map.get(cur);
        if (Objects.isNull(curMap)) {
            return null;
        }
        if (target.equals(cur)) {
            return 1.0;
        }
        Double v = curMap.get(target);
        if (v != null) {
            return v;
        }
        for (Map.Entry<String, Double> entry : curMap.entrySet()) {
            if (visited.contains(entry.getKey())) {
                continue;
            }
            visited.add(entry.getKey());
            Double v1 = get(map, entry.getKey(), target, visited);
            if (v1 != null) {
                return v1 * entry.getValue();
            }
        }
        return null;
    }
}