package com.ticket.manger.service;

import com.ticket.manger.dto.TicketDto;
import com.ticket.manger.dto.TicketSubmitionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    @Override
    public List<TicketDto> getMyTickets() {
        return null;
    }

    @Override
    public TicketSubmitionDto get(Long id) {
        return null;
    }

    @Override
    public void save(TicketSubmitionDto ticketSubmitionDto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, TicketSubmitionDto ticketSubmitionDto) {

    }
}
