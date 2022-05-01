package com.escher.webservice;

import com.escher.webservice.models.BlogEntry;
import com.escher.webservice.services.BlogEntryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogEntryServiceUnitTest {

    @Autowired
    private BlogEntryService blogEntryService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<BlogEntry> entries = blogEntryService.getAllBlogEntries();

        Assertions.assertEquals(entries.size(), 3);
    }
}