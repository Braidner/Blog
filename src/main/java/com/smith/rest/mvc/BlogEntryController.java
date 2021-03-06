package com.smith.rest.mvc;

import com.smith.core.entities.BlogEntry;
import com.smith.core.services.BlogEntryService;
import com.smith.rest.resources.BlogEntryResource;
import com.smith.rest.resources.asm.BlogEntryResourceAsm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rest/blog-entries")
public class BlogEntryController {
    private BlogEntryService service;

    public BlogEntryController(BlogEntryService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{blogEntryId}", method = RequestMethod.GET)
    public ResponseEntity<BlogEntryResource> getBlogEntry(
            @PathVariable Long blogEntryId) {
        BlogEntry entry = service.find(blogEntryId);
        if (entry == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        BlogEntryResource res = new BlogEntryResourceAsm().toResource(entry);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
