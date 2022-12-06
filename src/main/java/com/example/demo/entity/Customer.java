package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMER")
@SequenceGenerator(name = "generator_seq",
        sequenceName = "customer_id_seq",
        allocationSize = 1,
        initialValue = 1)
public class Customer extends BaseEntity {

//    @Idcustomer_id_seq
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq_app")
//    private Long id;

    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String surname;
    @Column(length = 9)
    private String phoneNumber;
    private LocalDate birthDate;



    @OneToOne(mappedBy = "customer")
    private Address address;

    @OneToMany(mappedBy = "customer")
    private Set<Rent> rents = new HashSet();


}
