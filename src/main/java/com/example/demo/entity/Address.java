package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ADDRESS")
@SequenceGenerator(name = "generator_seq",
        sequenceName = "address_id_seq",
        allocationSize = 1,
        initialValue = 1)
public class Address extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq_app")
//    private Long id;

    @Column(length = 100, nullable = false)
    private String street;

    @Column(length = 6)
    private String zipCode;

    @Column(length = 25)
    private String houseNumber;

    @Column(length = 100, nullable = false)
    private String city;


    @OneToOne
    @JoinColumn(name="customer_id",referencedColumnName = "id")
    private Customer customer;
    //private Long customerId;

}
