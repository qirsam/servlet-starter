package com.qirsam.http.service;

import com.qirsam.http.dao.TicketDao;
import com.qirsam.http.dto.TicketDto;
import com.qirsam.http.entity.Ticket;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TicketService {
    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    public List<TicketDto> findAllByFlightId(Integer flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticket -> TicketDto.builder()
                        .id(ticket.getId())
                        .flightId(ticket.getFlightId())
                        .seatNo(ticket.getSeatNo()).build())
                .collect(toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }


}
