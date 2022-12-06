package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RENT")
@SequenceGenerator(name = "generator_seq",
        sequenceName = "rent_id_seq",
        allocationSize = 1,
        initialValue = 1)
public class Rent extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rent_id_seq_app")
//    private Long id;

    private Timestamp rentStarted;

    private Timestamp rentEnded;

    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="book_id", referencedColumnName = "id")
    private BookEntity bookEntity;

}
