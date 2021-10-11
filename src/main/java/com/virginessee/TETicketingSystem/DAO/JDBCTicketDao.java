package com.virginessee.TETicketingSystem.DAO;

import com.virginessee.TETicketingSystem.models.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCTicketDao implements TicketDAO {


    private JdbcTemplate jdbcTemplate;

    public JDBCTicketDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Ticket getTicketById(Long id) {
        String sql = "SELECT * FROM ticket WHERE id = ?;";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()){
            return mapRowtoTicket(results);
        }
            return null; // consider exceptions in future/ run time exception
    }

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> allTickets= new ArrayList<>();

        String sql = "SELECT * FROM ticket;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            allTickets.add(mapRowtoTicket(results));
        }
        return allTickets;
    }

    @Override
    public List<Ticket> getTicketsByCustomerId(Long id) {
        List<Ticket> ticketsByCustomerId= new ArrayList<>();

        String sql = "SELECT * FROM ticket WHERE customer_id = ?;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()){
            ticketsByCustomerId.add(mapRowtoTicket(results));
        }
        return ticketsByCustomerId;

    }

    @Override
    public List<Ticket> getTicketsByDepartmentId(Long id) {
        List<Ticket> ticketsByDeptId= new ArrayList<>();

        String sql = "SELECT * FROM ticket WHERE department_id = ?;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()){
            ticketsByDeptId.add(mapRowtoTicket(results));
        }
        return ticketsByDeptId;

    }

    @Override
    public List<Ticket> getTicketsByTechnicianId(Long id) {
        return null; // pending adding the technician id to the ticket model
    }

    @Override
    public List<Ticket> getTicketsByStatus(Long id) {
        List<Ticket> ticketsByStatusId= new ArrayList<>();

        String sql = "SELECT * FROM ticket WHERE status_id = ?;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()){
            ticketsByStatusId.add(mapRowtoTicket(results));
        }
        return ticketsByStatusId;
    }

    @Override
    public List<Ticket> getTicketsByTypeId(Long id) {
        List<Ticket> ticketsByTypeId= new ArrayList<>();

        String sql = "SELECT * FROM ticket WHERE type_id = ?;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()){
            ticketsByTypeId.add(mapRowtoTicket(results));
        }
        return ticketsByTypeId;

    }

    @Override
    public List<Ticket> getTicketsByCaseId(Long id) {
        List<Ticket> ticketsByCaseId= new ArrayList<>();

        String sql = "SELECT * FROM ticket WHERE case_id = ?;" ;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()){
            ticketsByCaseId.add(mapRowtoTicket(results));
        }
        return ticketsByCaseId;

    }

    @Override
    public void createTicket(Ticket ticket) {
        String sql = "INSERT INTO ticket (title, description, customer_id, type_id, screenshot, department_id, status_id) "+
                "VALUES (?,?,?,?,?,?,?); ";
        // conditional logic if necessary will be house in the controller
        jdbcTemplate.update(sql,ticket.getTitle(),ticket.getDescription(),ticket.getCustomerId(),ticket.getTypeId(),ticket.getScreenshotUrl(),ticket.getDepartmentId(),ticket.getStatusId());

    }

    @Override
    public void updateTicket(Ticket ticket) {
        String sql = "UPDATE ticket SET title=?, description=?, customer_id=?, type_id=?, screenshot=?, department_id=?, status_id=? WHERE id=? ;";
        // should we update everything, or the selected items that would likely change via biz logic.
        jdbcTemplate.update(sql,ticket.getTitle(),ticket.getDescription(),ticket.getCustomerId(),ticket.getTypeId(),ticket.getScreenshotUrl(),ticket.getDepartmentId(),ticket.getStatusId(), ticket.getId());
    }

    // 9.16.21 create methods to allow us to call on the specific description or type via the id
    // timestamp not added. it's in the model but omitted here until we decide.
    private Ticket mapRowtoTicket(SqlRowSet results){
        Ticket ticket = new Ticket();
        ticket.setId(results.getLong("id"));
        ticket.setTitle(results.getString("title"));
        ticket.setDescription(results.getString("description"));
        ticket.setCustomerId(results.getLong("customer_id"));
        ticket.setTypeId(results.getLong("type_id"));
        ticket.setScreenshotUrl(results.getString("screenshot"));
        ticket.setDepartmentId(results.getLong("department_id"));
        ticket.setStatusId(results.getLong("status_id"));
        return ticket;
    }
}
