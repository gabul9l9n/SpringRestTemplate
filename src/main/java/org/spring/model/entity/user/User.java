package org.spring.model.entity.user;

import lombok.*;
import org.spring.model.entity.address.Address;
import org.spring.model.entity.company.Company;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq") ////// почитать тут
    @SequenceGenerator(name = "users_seq", sequenceName = "sql_sequence_user_id", allocationSize = 1)
    @Column(name = "u_id")
    private int id;

    @Column(name = "u_name")
    private String name;

    @Column(name = "u_username")
    private String username;

    @Column(name = "u_email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "u_phone")
    private String phone;

    @Column(name = "u_website")
    private String website;

    @OneToOne(cascade = CascadeType.ALL) ///// почитать тут
    @JoinColumn(name = "company_id")
    private Company company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(phone, user.phone) && Objects.equals(website, user.website) && Objects.equals(company, user.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, email, address, phone, website, company);
    }
}