package org.spring.model.dto.geo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class GeoDto {
    private String lat;
    private String lng;
}