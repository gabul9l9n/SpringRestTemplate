package org.spring.service;

import org.spring.exception.WebsiteNotFoundException;
import org.spring.model.dto.website.WebsiteDto;
import org.spring.model.dto.website.WebsiteRestDto;
import org.spring.model.dto.website.WebsitesRestDto;
import org.spring.model.entity.website.StackOverflowWebsite;
import org.spring.repository.StackOverflowWebsiteRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StackOverflowService {
    private static final String BASE_URL = "https://api.stackexchange.com/2.3/sites?page=1&pagesize=999&filter=!)MPhOgqWK*7)9aOiVK1";
    private final StackOverflowWebsiteRepository websiteRepository;
    private final RestTemplate restTemplate;

    public StackOverflowService(StackOverflowWebsiteRepository websiteRepository, RestTemplate restTemplate) {
        this.websiteRepository = websiteRepository;
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<WebsitesRestDto> getSites() {
        return restTemplate.exchange(BASE_URL, HttpMethod.GET, new ResponseEntity<List<WebsitesRestDto>>(HttpStatus.OK), WebsitesRestDto.class);
    }

    public List<StackOverflowWebsite> findAllByRestTemplate() {
        return Objects.requireNonNull(getSites().getBody()).getItems().stream().
                map(this::toStackOverflowWebsite).
                filter(stackOverflowWebsite -> !stackOverflowWebsite.getWebsite().contains("meta.")).
                collect(Collectors.toList());
    }

    public void saveAll() {
        websiteRepository.saveAll(findAllByRestTemplate());
    }

    public List<WebsiteDto> findAll() {
        return websiteRepository.findAll().stream().map(this::toWebsiteDto).collect(Collectors.toList());
    }

    public List<WebsiteDto> findAllPaging(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("name"));
        return websiteRepository.findAll(pageable).map(this::toWebsiteDto).toList();
    }

    public WebsiteDto findById(String name) {
            return websiteRepository.findById(name).map(this::toWebsiteDto).orElseThrow(() -> new WebsiteNotFoundException(name));
    }

    private StackOverflowWebsite toStackOverflowWebsite(WebsiteRestDto websiteRestDto) {
        return new StackOverflowWebsite(
                websiteRestDto.getSite_url().substring("https://".length(), websiteRestDto.getSite_url().length() - ".com".length()),
                websiteRestDto.getSite_url(),
                websiteRestDto.getFavicon_url(),
                websiteRestDto.getName(),
                websiteRestDto.getAudience()
        );
    }

    private WebsiteDto toWebsiteDto(StackOverflowWebsite stackOverflowWebsite) {
        return new WebsiteDto(
                stackOverflowWebsite.getName(),
                stackOverflowWebsite.getWebsite(),
                stackOverflowWebsite.getIconImageUrl(),
                stackOverflowWebsite.getTitle(),
                stackOverflowWebsite.getDescription()
        );
    }
}