package org.spring.repository;

import org.spring.model.entity.website.StackOverflowWebsite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StackOverflowWebsiteRepository extends JpaRepository<StackOverflowWebsite, String> {
    List<StackOverflowWebsite> findAll();

    Page<StackOverflowWebsite> findAll(Pageable pageable);
}