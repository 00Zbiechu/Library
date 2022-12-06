package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Component
public class DatabaseInitializer {

    private final AddressRepository addressRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    private final RentRepository rentRepository;


/*
    @PostConstruct
    public void initDatabase(){

        Customer customer = Customer.builder()
                .firstName("Mateusz")
                .surname("Zbiewski")
                .phoneNumber("123456789")
                .birthDate(LocalDate.of(2000,2,20))
                .build();

        customerRepository.save(customer);

        Address address = Address.builder()
                .street("Podgorna")
                .zipCode("75-400")
                .houseNumber("3/2")
                .city("Koszalin")
                .customer(customer)
                .build();

        addressRepository.save(address);





        Author author = Author.builder()
                .firstName("Adam")
                .surname("Mickiewicz")
                .birthDate(LocalDate.of(1798,12,24))
                .build();

        authorRepository.save(author);


        BookEntity bookEntity = BookEntity.builder()
                .status("Wypożyczona")
                .title("Pan Tadeusz")
                .createYear((short) 1834)
                .authors(Set.of(author))
                .build();

        bookRepository.save(bookEntity);




        Rent rent = Rent.builder()
                .rentStarted(new Timestamp(System.currentTimeMillis()))
                .rentEnded(new Timestamp(System.currentTimeMillis()))
                .customer(customer)
                .bookEntity(bookEntity)
                .build();

        rentRepository.save(rent);



    }


 */

}
