package com.smith.core.services;

import com.smith.core.entities.BlogEntry;

/**
 * Created with IntelliJ IDEA.
 * User: Braidner
 * Date: 14.09.14
 * Time: 7:36
 */
public interface BlogEntryService {
    public BlogEntry find(Long id);
}
