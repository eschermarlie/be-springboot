package com.escher.webservice.web;

import java.util.List;

import com.escher.webservice.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpHeaders;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.escher.webservice.models.BlogEntry;
        import com.escher.webservice.services.BlogEntryService;

@RestController
@CrossOrigin
@RequestMapping("/blogEntries")
public class BlogEntryController
{
    @Autowired
    BlogEntryService blogEntry;

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<BlogEntry>> getAllBlogEntries() {
        List<BlogEntry> list = blogEntry.getAllBlogEntries();

        return new ResponseEntity<List<BlogEntry>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<BlogEntry> getBlogEntryById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        BlogEntry entity = blogEntry.getBlogEntryById(id);

        return new ResponseEntity<BlogEntry>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<BlogEntry> createOrUpdateBlogEntry(@RequestBody BlogEntry newEntry)
            throws RecordNotFoundException {
        BlogEntry updated = blogEntry.createOrUpdateBlogEntry(newEntry);
        return new ResponseEntity<BlogEntry>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public HttpStatus deleteBlogEntryById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        blogEntry.deleteBlogEntryById(id);
        return HttpStatus.FORBIDDEN;
    }

}