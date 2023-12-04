package com.github.morningwn.create.base;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;

/**
 * @author morningwn
 * @date 2023/12/1 10:13
 */
public class FileMaker {
    private static String baseDir = "/Users/mac/IdeaProjects/leetcode/src/main/";

    public static void makeAllFile(Detail detail) {
        if (detail == null) {
            return;
        }
        makeJavaFile(detail);
        makeCFile(detail);
    }

    public static void makeJavaFile(Detail detail) {
        try {
            File file = new File(baseDir + "java/" + detail.getPackageName().replaceAll("\\.", "/") + "/J" + detail.getFileSuffix() + ".java");
            if (file.exists()) {
                return;
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
            URL resource = FileTransfer.class.getClassLoader().getResource("");
            cfg.setDirectoryForTemplateLoading(new File(resource.getPath() + "/template"));
            Template template = cfg.getTemplate("Java.ftl");

            FileWriter fileWriter = new FileWriter(file);
            template.process(detail, fileWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void makeCFile(Detail detail) {
        try {
            File file = new File(baseDir + "c/" + detail.getFileDir().replaceAll("\\.", "/") + "/C" + detail.getFileSuffix() + ".c");
            if (file.exists()) {
                return;
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
            URL resource = FileTransfer.class.getClassLoader().getResource("");
            cfg.setDirectoryForTemplateLoading(new File(resource.getPath() + "/template"));

            Template template = cfg.getTemplate("C.ftl");
            FileWriter fileWriter = new FileWriter(file);
            template.process(detail, fileWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
