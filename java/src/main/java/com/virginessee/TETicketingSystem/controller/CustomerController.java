package com.virginessee.TETicketingSystem.controller;

import com.virginessee.TETicketingSystem.dao.CustomerDAO;
import com.virginessee.TETicketingSystem.dao.TicketDAO;
import com.virginessee.TETicketingSystem.dao.UserDao;
import com.virginessee.TETicketingSystem.model.Customer;
import com.virginessee.TETicketingSystem.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    TicketDAO ticketDAO;
    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    UserDao userDAO;

    @RequestMapping(path = "/customer", method = RequestMethod.GET)
    public Customer getCustomer(Principal principal) {
        return customerDAO.getCustomerByUserId((long) userDAO.findIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/customer/tickets", method = RequestMethod.GET)
    public List<Ticket> getTickets(Principal principal) {
        return ticketDAO.getTicketsByCustomerId(customerDAO.getCustomerByUserId((long) userDAO.findIdByUsername(principal.getName())).getId());
    }

    @RequestMapping(path = "/customer/tickets", method = RequestMethod.POST)
    public void createTicket(@RequestBody Ticket ticket) {
        ticketDAO.createTicket(ticket);
    }

}
