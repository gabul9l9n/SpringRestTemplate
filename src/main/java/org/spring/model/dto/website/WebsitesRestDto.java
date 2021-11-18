package org.spring.model.dto.website;

import lombok.Data;

import java.util.List;

@Data
public class WebsitesRestDto {
    private List<WebsiteRestDto> items;
}