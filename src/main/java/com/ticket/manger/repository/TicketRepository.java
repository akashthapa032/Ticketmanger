package com.ticket.manger.repository;

import com.ticket.manger.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByTicketSubject(String ticketSubject);
    List<Ticket> findAllByTicketSubjectAndId(String ticketSubjectt, Long id);

    Optional<Ticket> findById(Long id);
}
