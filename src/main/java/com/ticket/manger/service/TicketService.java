package com.ticket.manger.service;

import com.ticket.manger.dto.TicketDto;
import com.ticket.manger.dto.TicketSubmitionDto;

import java.util.List;

public interface TicketService {
    List<TicketDto> getMyTickets();

    TicketSubmitionDto get(Long id);

    void save(TicketSubmitionDto ticketSubmitionDto);
    void delete(Long id);
    void update(Long id, TicketSubmitionDto ticketSubmitionDto);
}
