package com.github.morningwn.create.base;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.github.morningwn.tag.Difficulty;

import java.util.List;

/**
 * @author morningwn
 * @create in 2022/8/16 16:28
 */
public class Detail {
    private Integer id;
    private String fileDir;
    private String packageName;
    private String title;
    private String titleSlug;
    private String javaCode;
    private String cCode;
    private String fileSuffix;
    public List<String> topics;
    private String difficulty;
    private List<String> importClassList;
    private List<String> includeList;

    private String dataTime = DateUtil.formatDateTime(DateTime.now());

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
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

    public void setDifficulty(Integer level) {
        switch (level) {
            case 1 -> this.difficulty = Difficulty.Easy.name();
            case 2 -> this.difficulty = Difficulty.Medium.name();
            case 3 -> this.difficulty = Difficulty.Hard.name();
            default -> this.difficulty = "";
        }
    }

    public List<String> getImportClassList() {
        return importClassList;
    }

    public void setImportClassList(List<String> importClassList) {
        this.importClassList = importClassList;
    }

    public List<String> getIncludeList() {
        return includeList;
    }

    public void setIncludeList(List<String> includeList) {
        this.includeList = includeList;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }
}
