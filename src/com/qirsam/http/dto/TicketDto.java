package com.qirsam.http.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketDto {

    Long id;
    Integer flightId;
    String seatNo;
}

