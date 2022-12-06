package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AUTHOR")
@SequenceGenerator(name = "generator_seq",
        sequenceName = "author_id_seq",
        allocationSize = 1,
        initialValue = 1)
public class Author extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq_app")
//    private Long id;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String surname;

    private LocalDate birthDate;


    @ManyToMany(mappedBy = "authors")
    private Set<BookEntity> books = new HashSet<>();

}
