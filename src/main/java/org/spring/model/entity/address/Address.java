package org.spring.model.entity.address;

import lombok.*;
import org.spring.model.entity.geo.Geo;
import org.spring.model.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "sql_sequence_address_id", allocationSize = 1)
    @Column(name = "a_id")
    private int id;

    @Column(name = "a_street")
    private String street;

    @Column(name = "a_suite")
    private String suite;

    @Column(name = "a_city")
    private String city;

    @Column(name = "a_zipcode")
    private String zipcode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_id")
    private Geo geo;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address(int id, String street, String suite, String city, String zipcode, Geo geo) {
        this.id = id;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }
}