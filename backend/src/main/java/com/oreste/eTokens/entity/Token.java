package com.oreste.eTokens.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "TOKEN")
public class Token {
    @Id
    @Column(name = "TOKEN_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tokenId;

    @Column(name = "TOKEN_NUMBER")
    private String tokenNumber;

    @Column(name = "NUMBER_OF_DAYS")
    private Integer numberOfDays;

    @Column(name = "METER_NUMBER")
    private String meterNumber;

    @Column(name = "IS_USED")
    private Boolean isUsed;
}
