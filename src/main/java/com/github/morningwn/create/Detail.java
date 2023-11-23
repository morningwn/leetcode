package com.github.morningwn.create;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.github.morningwn.tag.Difficulty;
import com.github.morningwn.tag.Topic;

import java.util.List;

/**
 * @author morningwn
 * @create in 2022/8/16 16:28
 */
public class Detail {
    private String packageName;
    private Integer id;
    private String title;
    private String titleSlug;
    private String javaCode;
    public String className;
    public List<String> topics;
    private String difficulty;
    private List<String> importClassList;
    private String dataTime = DateUtil.formatDateTime(DateTime.now());

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return "https://leetcode.cn/problems/" + titleSlug + "/";
    }

    public String getTitleSlug() {
        return titleSlug;
    }

    public void setTitleSlug(String titleSlug) {
        this.titleSlug = titleSlug;
    }

    public String getJavaCode() {
        return javaCode;
    }

    public void setJavaCode(String javaCode) {
        this.javaCode = javaCode;
    }

    public List<String> getImportClassList() {
        return importClassList;
    }

    public void setImportClassList(List<String> importClassList) {
        this.importClassList = importClassList;
    }

    public String getDataTime() {
        return dataTime;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
