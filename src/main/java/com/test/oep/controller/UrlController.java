package com.test.oep.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.oep.service.UrlMappingService;

@Controller
public class UrlController {
    @Autowired
    private UrlMappingService urlMappingService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam("longUrl") String longUrl, Model model) {
        // Shorten the URL and return the result
   
        String shortUrl = urlMappingService.generateShortUrl(longUrl);
        String fullShortUrl = urlMappingService.getFullShortUrl(shortUrl);

        model.addAttribute("shortUrl", fullShortUrl);
        return "result";
    }

    @GetMapping("/{shortUrl}")
    public void redirectToLongUrl(@PathVariable("shortUrl") String shortUrl, HttpServletResponse response) throws IOException {
        // Rest of the code
           String longUrl = urlMappingService.getLongUrl(shortUrl);
        if (longUrl != null) {
            response.sendRedirect(longUrl);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}