package com.github.morningwn.create;

/**
 * @author morningwn
 * @create in 2022/8/15 18:58
 */
public class TagEntity {
    private String name;
    private String chineseName;
    private String slug;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return "https://leetcode.cn/tag/" + this.slug + "/problemset/";
    }
}
