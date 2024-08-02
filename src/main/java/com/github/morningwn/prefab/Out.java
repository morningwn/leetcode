package com.github.morningwn.prefab;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author morningwn
 * @create in 2022/8/11 14:16
 */
public class Out {

    public static void print(String s) {
        System.out.print(s);
    }

    public static void print(List<?> list) {
        System.out.print(JSONUtil.toJsonStr(list));
    }

    public static void print(Map<?, ?> map) {
        System.out.print(JSONUtil.toJsonStr(map));
    }

    public static void print(int o) {
        System.out.print(o);
    }

    public static void print(long o) {
        System.out.print(o);
    }

    public static void print(boolean o) {
        System.out.print(o);
    }

    public static void print(double o) {
        System.out.print(o);
    }

    public static void print(int[] o) {
        System.out.print(JSONUtil.toJsonStr(o));
    }

    public static void print(Object o) {
        System.out.print(JSONUtil.toJsonStr(o));
    }

    public static void println() {
        System.out.println();
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void println(List<?> list) {
        System.out.println(JSONUtil.toJsonStr(list));
    }

    public static void println(Map<?, ?> map) {
        System.out.println(JSONUtil.toJsonStr(map));
    }

    public static void println(char o) {
        System.out.println(o);
    }

    public static void println(int o) {
        System.out.println(o);
    }

    public static void println(long o) {
        System.out.println(o);
    }

    public static void println(boolean o) {
        System.out.println(o);
    }

    public static void println(double d) {
        System.out.println(d);
    }

    public static void println(int[] o) {
        System.out.println(JSONUtil.toJsonStr(o));
    }

    public static void println(Object o) {
        System.out.println(JSONUtil.toJsonStr(o));
    }

    public static void println(Object... os) {
        for (Object o : os) {
            System.out.println(JSONUtil.toJsonStr(o));
        }
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void printlnf(String format, Object... args) {
        System.out.printf(format, args);
        System.out.println();
    }

    public static void toFile(String path, Object args) {
        File file = new File(path);
        FileUtil.writeString(JSONUtil.toJsonStr(args), file, StandardCharsets.UTF_8);
    }
}
