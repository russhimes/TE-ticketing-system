package com.virginessee.TETicketingSystem.DAO;

import com.virginessee.TETicketingSystem.models.*;

import java.util.List;

public interface TicketDAO {

    public Ticket getTicketById(Long id);

    public List<Ticket> getAllTickets();

    public List<Ticket> getTicketsByCustomerId(Long id);

    public List<Ticket> getTicketsByDepartmentId(Long id);

    public List<Ticket> getTicketsByStatus(Long id);

    public List<Ticket> getTicketsByTypeId(Long id);

    public List<Ticket> getTicketsByCaseId(Long id);

    public void createTicket(Ticket ticket); //9.16.21 changed to void

    public void updateTicket(Ticket ticket);

    //public void setStatus(Ticket ticket);

    //public void updateDescription(Ticket ticket);

    //public void setType(Ticket ticket);

    //public void setScreenshot(Ticket ticket);

    //if there isn't a case already assigned only
   // public void assignToCase(Ticket ticket);


}
