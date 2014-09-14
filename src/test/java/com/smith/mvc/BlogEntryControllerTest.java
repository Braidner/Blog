package com.smith.mvc;

import com.smith.core.entities.BlogEntry;
import com.smith.core.services.BlogEntryService;
import com.smith.rest.mvc.BlogEntryController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BlogEntryControllerTest {

    @InjectMocks
    private BlogEntryController controller;

    @Mock
    private BlogEntryService service;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getExistingBlogEntry() throws Exception {
        BlogEntry entry = new BlogEntry();
        entry.setId(1L);
        entry.setTitle("Test Title");

        when(service.find(1L)).thenReturn(entry);

        mockMvc.perform(get("/rest/blog-entries/1"))
                .andDo(print())
                .andExpect(jsonPath("$.title", is(entry.getTitle())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void getNonExistingBlogEntry() throws Exception {
        when(service.find(1L)).thenReturn(null);

        mockMvc.perform(get("/rest/blog-entries/1"))
                .andExpect(status().isNotFound());
    }
}