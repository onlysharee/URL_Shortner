package com.test.oep.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.oep.entity.UrlMapping;
import com.test.oep.repository.UrlMappingRepository;

@Service
public class UrlMappingService {
    private static final String BASE_URL = "http://localhost:8080/";

    @Autowired
    private UrlMappingRepository urlMappingRepository;

    public String generateShortUrl(String longUrl) {
        String shortUrl = generateRandomShortUrl();

        // Check if the short URL already exists in the database
        UrlMapping existingMapping = urlMappingRepository.findByShortUrl(shortUrl);
        if (existingMapping != null) {
            return generateShortUrl(longUrl);
        }

        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setLongUrl(longUrl);
        urlMapping.setShortUrl(shortUrl);

        urlMappingRepository.save(urlMapping);

        return shortUrl;
    }

    private String generateRandomShortUrl() {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }

    public String getLongUrl(String shortUrl) {
        UrlMapping urlMapping = urlMappingRepository.findByShortUrl(shortUrl);
        if (urlMapping != null) {
            return urlMapping.getLongUrl();
        }
        return null;
    }

    public String getFullShortUrl(String shortUrl) {
        return BASE_URL + shortUrl;
    }
}
