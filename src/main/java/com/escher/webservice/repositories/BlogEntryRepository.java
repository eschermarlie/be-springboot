package com.escher.webservice.repositories;

import com.escher.webservice.models.BlogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogEntryRepository
        extends JpaRepository<BlogEntry, Long> {

}