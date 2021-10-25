package com.ticket.manger.controller;

import com.ticket.manger.dto.TicketDto;
import com.ticket.manger.dto.TicketSubmitionDto;
import com.ticket.manger.dto.TicketWrapperDto;
import com.ticket.manger.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired

    private TicketService ticketService;


    @GetMapping("")
    public TicketWrapperDto getTicektCreatedByUserList(){
        List<TicketDto> data = ticketService.getMyTickets();
        TicketWrapperDto ticketWrapperDto = new TicketWrapperDto();
        ticketWrapperDto.setData(data);
        return ticketWrapperDto;

    }

    @PostMapping("")
    public void save (@Valid @RequestBody TicketSubmitionDto ticketSubmitionDto){
        ticketService.save(ticketSubmitionDto);
    }

    @GetMapping("/{id}")
    public TicketSubmitionDto read(@PathVariable Long id){
        return ticketService.get(id);

    }
     @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody TicketSubmitionDto ticketSubmitionDto){
        ticketService.update(id, ticketSubmitionDto);
     }

     @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        ticketService.delete(id);
     }
}
