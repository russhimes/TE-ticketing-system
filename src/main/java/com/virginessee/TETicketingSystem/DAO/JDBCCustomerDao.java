package com.virginessee.TETicketingSystem.DAO;

import com.virginessee.TETicketingSystem.models.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCCustomerDao implements CustomerDAO{

    private JdbcTemplate jdbcTemplate;

    public JDBCCustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer getCustomerById(Long id) {
        String sql= "SELECT * FROM customer WHERE id= ?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql,id);
        if(results.next()){
            return mapRowToCustomer(results);
        }
        return null; // consider exception handling
    }

    @Override
    public Customer getCustomerByUserId(Long id) {
        String sql= "SELECT * FROM customer WHERE sys_user_id= ?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql,id);
        if(results.next()){
            return mapRowToCustomer(results);
        }
        return null; // consider exception handling
    }

    private Customer mapRowToCustomer(SqlRowSet results){
        Customer customer= new Customer();
        customer.setId(results.getLong("id"));
        customer.setDepartmentId(results.getLong("department_id"));
        customer.setUserId(results.getLong("sys_user_id"));
        customer.setName(results.getString("name"));
        return customer;
    }
}
