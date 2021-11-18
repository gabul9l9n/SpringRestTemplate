package org.spring.model.entity.geo;

import lombok.*;
import org.spring.model.entity.address.Address;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Geo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geo_seq")
    @SequenceGenerator(name = "geo_seq", sequenceName = "sql_sequence_geo_id", allocationSize = 1)
    @Column(name = "g_id")
    private int id;

    @Column(name = "g_lat")
    private String lat;

    @Column(name = "g_lng")
    private String lng;

    @OneToOne(mappedBy = "geo")
    private Address address;

    public Geo(int id, String lat, String lng) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
    }
}