package com.virginessee.TETicketingSystem.dao;

import com.virginessee.TETicketingSystem.model.Technician;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCTechnicianDao implements TechnicianDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCTechnicianDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Technician getTechnicianByTechnicianId(Long id) {
        String sql= "SELECT * FROM technician WHERE id = ?;";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql,id);
        if(results.next()){
            return mapRowToTechnician(results);
        }
        return null; // consider writing exception if you didn't get a result instead
    }

    @Override
    public Technician getTechnicianByUserId(Long id) {
        String sql= "SELECT * FROM technician WHERE sys_user_id = ?;";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql,id);
        if(results.next()){
            return mapRowToTechnician(results);
        }
        return null;
    }

    @Override
    public List<Technician> getTechniciansByDept(Long id) {
        List<Technician> techniciansByDept= new ArrayList<>();

        String sql= "SELECT * FROM technician WHERE department_id =? ;";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql,id);
        while (results.next()){
            techniciansByDept.add(mapRowToTechnician(results));
        }
        return techniciansByDept;
    }

    private Technician mapRowToTechnician(SqlRowSet results){
        Technician technician = new Technician();
        technician.setId(results.getLong("id"));
        technician.setDepartmentId(results.getLong("department_id"));
        technician.setUserId(results.getLong("sys_user_id"));
        technician.setName(results.getString("name"));
        return technician;
    }
}
