package org.spring.model.dto.website;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebsiteDto {
    private String name;
    private String site_url;
    private String favicon_url;
    private String title;
    private String audience;
}
