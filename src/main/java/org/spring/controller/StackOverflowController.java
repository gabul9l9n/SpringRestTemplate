package org.spring.controller;

import org.spring.model.dto.website.WebsiteDto;
import org.spring.service.StackOverflowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sites")
public class StackOverflowController {
    private final StackOverflowService stackOverflowService;

    public StackOverflowController(StackOverflowService stackOverflowService) {
        this.stackOverflowService = stackOverflowService;
    }

    @GetMapping("")
    public ResponseEntity<List<WebsiteDto>> getAllWebsitesPaging(@RequestParam int page) {
        return new ResponseEntity<>(stackOverflowService.findAllPaging(page), HttpStatus.OK);
    }

    @GetMapping("/rest")
    public ResponseEntity<List<WebsiteDto>> getAllWebsitesRest() {
        return new ResponseEntity<>(stackOverflowService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/rest")
    public void addAllWebsitesRest() {
        stackOverflowService.saveAll();
    }

    @GetMapping("/{siteName}")
    public WebsiteDto getWebsite(@PathVariable String siteName) {
        return stackOverflowService.findById(siteName);
    }
}