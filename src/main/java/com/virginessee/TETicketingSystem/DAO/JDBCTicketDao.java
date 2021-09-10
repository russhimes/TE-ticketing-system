package com.virginessee.TETicketingSystem.DAO;

import com.virginessee.TETicketingSystem.models.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JDBCTicketDao implements TicketDAO {


    private JdbcTemplate jdbcTemplate;

    public JDBCTicketDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Ticket getTicketById(Long id) {
        String sql = ""
    }

    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }

    @Override
    public List<Ticket> getTicketsByCustomerId(Long id) {
        return null;
    }

    @Override
    public List<Ticket> getTicketsByDepartmentId(Long id) {
        return null;
    }

    @Override
    public List<Ticket> getTicketsByStatus(Long id) {
        return null;
    }

    @Override
    public List<Ticket> getTicketsByTypeId(Long id) {
        return null;
    }

    @Override
    public List<Ticket> getTicketsByCaseId(Long id) {
        return null;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return null;
    }

    @Override
    public void updateTicket(Ticket ticket) {

    }
}
