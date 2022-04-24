package com.qirsam.http.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Ticket {
    private Long id;
    private String passengerNo;
    private String passengerName;
    private Integer flightId;
    private String seatNo;
    private BigDecimal cost;
}
