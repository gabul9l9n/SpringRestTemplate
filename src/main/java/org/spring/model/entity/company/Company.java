package org.spring.model.entity.company;

import lombok.*;
import org.spring.model.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
    @SequenceGenerator(name = "company_seq", sequenceName = "sql_sequence_company_id", allocationSize = 1)
    @Column(name = "c_id")
    private int id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_catch_phrase")
    private String catchPhrase;

    @Column(name = "c_bs")
    private String bs;

    @OneToOne(mappedBy = "company")
    private User user;

    public Company(int id, String name, String catchPhrase, String bs) {
        this.id = id;
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }
}