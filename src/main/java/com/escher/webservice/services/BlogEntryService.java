package com.escher.webservice.services;

import com.escher.webservice.models.BlogEntry;
import com.escher.webservice.repositories.BlogEntryRepository;
import com.escher.webservice.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class BlogEntryService {

    @Autowired
    BlogEntryRepository repository;

    public List<BlogEntry> getAllBlogEntries()
    {
        List<BlogEntry> blogEntryList = repository.findAll();

        if(blogEntryList.size() > 0) {
            return blogEntryList;
        } else {
            return new ArrayList<BlogEntry>();
        }
    }

    public BlogEntry getBlogEntryById(Long id) throws RecordNotFoundException
    {
        Optional<BlogEntry> blogEntry = repository.findById(id);

        if(blogEntry.isPresent()) {
            return blogEntry.get();
        } else {
            throw new RecordNotFoundException("No blogEntry record exist for given id");
        }
    }

    public BlogEntry createOrUpdateBlogEntry(BlogEntry entity) throws RecordNotFoundException
    {
        Optional<BlogEntry> blogEntry = repository.findById(entity.getId());
        if(blogEntry.isPresent())
        {
            BlogEntry newEntity = blogEntry.get();
            newEntity.setAuthor(entity.getAuthor());
            newEntity.setTitle(entity.getTitle());
            newEntity.setContent(entity.getContent());
            newEntity.setTotalViews(entity.getTotalViews());
            newEntity.setImageURL(entity.getImageURL());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteBlogEntryById(Long id) throws RecordNotFoundException
    {
        Optional<BlogEntry> blogEntry = repository.findById(id);

        if(blogEntry.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No blogEntry record exist for given id");
        }
    }
}