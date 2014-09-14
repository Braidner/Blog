package com.smith.core.entities;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 13.09.14
 * Time: 20:06
 */
public class BlogEntry {
    private Long id;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
