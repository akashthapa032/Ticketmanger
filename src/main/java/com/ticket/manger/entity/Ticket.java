package com.ticket.manger.entity;


import com.ticket.manger.enums.TicketType;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Date;

@Entity(name="tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="ticket_subject",nullable = false)
    private String ticketSubject;

    @Column(name="ticket-description")
    private String ticketDescritpion;

   @Enumerated (EnumType.STRING)
    @Column(name="ticket_type", nullable = false)
    private TicketType ticketType;

   @JoinColumn(name="user_created_by_id")
    @ManyToOne
    private Users createdBy;

   @JoinColumn(name="user_worked_by_id")
    @ManyToOne
    private Users workedBy;

   @Column(name="created_date")
    private Date createdDate;

   @Column(name="last_updated")
    private Date lastUpdated;

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketSubject() {
        return ticketSubject;
    }

    public void setTicketSubject(String ticketSubject) {
        this.ticketSubject = ticketSubject;
    }

    public String getTicketDescritpion() {
        return ticketDescritpion;
    }

    public void setTicketDescritpion(String ticketDescritpion) {
        this.ticketDescritpion = ticketDescritpion;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    public Users getWorkedBy() {
        return workedBy;
    }

    public void setWorkedBy(Users workedBy) {
        this.workedBy = workedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @PrePersist
    void saveDateCreated(){
        this.createdDate = new Date();
    }

    @PreUpdate
    void savelastUpdatedDate(){
        this.lastUpdated = new Date();
    }
}
