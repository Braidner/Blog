package com.smith.rest.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 14.09.14
 * Time: 7:29
 */
public class BlogEntryResource extends ResourceSupport {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
