package com.ticket.manger.dto;

import com.ticket.manger.enums.TicketType;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TicketSubmitionDto {
    @NonNull
    @NotBlank
    @Size(max = 100)
    private String ticketSubject;

    @NotBlank
    @NotNull
    private TicketType type;

    private String description;

    private String link;

    private String createdBy;

    private String workedBy;

    private String datedCreated;

    private String lastUpdated;

    public String getDatedCreated() {
        return datedCreated;
    }

    public void setDatedCreated(String datedCreated) {
        this.datedCreated = datedCreated;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getTicketSubject() {
        return ticketSubject;
    }

    public void setTicketSubject(@NonNull String ticketSubject) {
        this.ticketSubject = ticketSubject;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getWorkedBy() {
        return workedBy;
    }

    public void setWorkedBy(String workedBy) {
        this.workedBy = workedBy;
    }

    @Override
    public String toString() {
        return "TicketSubmitionDto " +
                "[ticketSubject='" + ticketSubject + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", workedBy='" + workedBy + '\'' +
                ", datedCreated='" + datedCreated + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ']';
    }
}
