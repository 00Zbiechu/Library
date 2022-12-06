package com.example.demo.entity;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOK")
@SequenceGenerator(name = "generator_seq",
        sequenceName = "book_id_seq",
        allocationSize = 1,
        initialValue = 1)
public class BookEntity extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq_app")
//    private Long id;

    @Column(length = 25, nullable = false)
    private String status;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 4, nullable = false)
    private Short createYear;





    @OneToMany(mappedBy = "bookEntity")
    private Set<Rent> rents = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "AUTHOR_BOOK",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    private Set<Author> authors = new HashSet<>();

    //private Long authorId;

}
