package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class RentDTO {

    private Long id;

    private Timestamp rentStarted;

    private Timestamp rentEnded;


}
