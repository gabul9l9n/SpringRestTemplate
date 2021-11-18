package org.spring.model.dto.website;

import lombok.Data;

@Data
public class WebsiteRestDto {
    private String site_url;
    private String favicon_url;
    private String name;
    private String audience;
}