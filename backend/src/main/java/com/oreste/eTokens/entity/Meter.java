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
@Table(name = "METER")
public class Meter {
    @Id
    @Column(name = "METER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long meterId;

    @Column(name = "METER_NUMBER")
    private String meterNumber;

    @Column(name = "BILL_EXPIRATION")
    private Date billExpiration;
}
