package org.spring.model.dto.address;

import lombok.*;
import org.spring.model.dto.geo.GeoDto;

@Data
public class AddressDto {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDto geo;
}
