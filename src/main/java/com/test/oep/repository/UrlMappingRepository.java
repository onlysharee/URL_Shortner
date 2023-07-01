package com.test.oep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.oep.entity.UrlMapping;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    UrlMapping findByShortUrl(String shortUrl);
}
