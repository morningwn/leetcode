package com.github.morningwn.create;

/**
 * @author morningwn
 * @create in 2022/8/15 19:15
 */
public enum Tags {
    /**
     * 数组
     */
    Array("数组", "array", "");


    private String name;
    private String slug;
    private String url;

    Tags(String name, String slug, String url) {
        this.name = name;
        this.slug = slug;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getUrl() {
        return url;
    }

    
}
