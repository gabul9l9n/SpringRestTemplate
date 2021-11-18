package org.spring.model.entity.website;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

///**
// * Entity with a composite primary key defined by @EmbeddedId
// */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Website", indexes = {
        @Index(name = "idx_website_on_name", columnList = "name", unique = true)})
public class StackOverflowWebsite implements Serializable {
//    @EmbeddedId
//    private StackOverflowWebsiteId id;
    @Id
    private String name;

    private String website;
    private String iconImageUrl;
    private String title;
    private String description;

//    @Version
//    private short version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackOverflowWebsite that = (StackOverflowWebsite) o;
        return Objects.equals(name, that.name) && Objects.equals(website, that.website) && Objects.equals(iconImageUrl, that.iconImageUrl) && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, website, iconImageUrl, title, description);
    }
}