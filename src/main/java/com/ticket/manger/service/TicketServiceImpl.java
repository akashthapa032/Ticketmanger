package com.ticket.manger.service;

import com.ticket.manger.dto.TicketDto;
import com.ticket.manger.dto.TicketSubmitionDto;
import com.ticket.manger.entity.Ticket;
import com.ticket.manger.entity.Users;
import com.ticket.manger.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketUserDetailService ticketUserDetailService;

    /**
     * get tickets created by me
     */
    @Override
    public List<TicketDto> getMyTickets() {
        return ticketRepository.findAll().stream().map(ticket -> {
            TicketDto dto = new TicketDto();
            dto.setId(ticket.getId());
            dto.setTicketSubject(ticket.getTicketSubject());
            dto.setCreatedBy(ticket.getCreatedBy().getName());
            dto.setDateCreated(ticket.getCreatedDate().toString());
            return dto;
        }).collect(Collectors.toList());

    }
    /**
     * get ticket by Id
     */

    @Override
    public TicketSubmitionDto get(Long id) {

        Optional<Ticket> optional = ticketRepository.findById(id);
        if(optional.isPresent()) {
            Ticket ticket = optional.get();
            TicketSubmitionDto dto = new TicketSubmitionDto();
            dto.setTicketSubject(ticket.getTicketSubject());
            dto.setDescription(ticket.getTicketDescription());
            dto.setCreatedBy(ticket.getCreatedBy().getName());
            Users workedBy = ticket.getWorkedBy();
            if (workedBy == null) {
                dto.setWorkedBy("Not Yet started");
            } else {
                dto.setWorkedBy(workedBy.getName());
            }
        if ( ticket.getLastUpdated() != null ){
            dto.setLastUpdated(ticket.getLastUpdated().toString());
        }
        dto.setDatedCreated(ticket.getCreatedDate().toString());
        dto.setType(ticket.getTicketType());
         return dto;
        }
        else {
            throw new RuntimeException("Recond not found");
        }
    }

    @Override
    public void save(TicketSubmitionDto ticketSubmitionDto) {
        Ticket ticket = new Ticket();
        ticket.setTicketSubject(ticketSubmitionDto.getTicketSubject());
        ticket.setTicketDescription(ticketSubmitionDto.getDescription());
        ticket.setTicketType(ticketSubmitionDto.getType());
        ticket.setCreatedBy(ticketUserDetailService.currentUser());
        ticketRepository.save(ticket);

    }

    @Override
    public void delete(Long id) {
        Optional<Ticket> optional = ticketRepository.findById(id);
        if(optional.isPresent()) {
            Ticket ticket = optional.get();
            ticketRepository.delete(ticket);

        }
         else {
             throw new RuntimeException("Record Not Found");
        }

    }

    @Override
    public void update(Long id, TicketSubmitionDto ticketSubmitionDto) {
        Optional<Ticket> optional = ticketRepository.findById(id);
        if(optional.isPresent()){
            Ticket ticket = optional.get();
            Users user = ticketUserDetailService.currentUser();

            if(!user.equals(ticket.getCreatedBy())){
                throw new RuntimeException("User does't have permissions to update");
            }

            ticket.setTicketSubject(ticketSubmitionDto.getTicketSubject());
            ticket.setTicketDescription(ticket.getTicketDescription());
            ticket.setTicketType(ticket.getTicketType());
            ticket.setCreatedBy(ticketUserDetailService.currentUser());
            ticketRepository.save(ticket);
        }
        else{
            throw new RuntimeException("Record not found");
        }

    }
}
