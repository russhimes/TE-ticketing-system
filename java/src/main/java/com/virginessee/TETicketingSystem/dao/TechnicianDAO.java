package com.virginessee.TETicketingSystem.dao;

import com.virginessee.TETicketingSystem.model.Technician;

import java.util.List;

public interface TechnicianDAO {

    // retrieve technician information when they log in
    public Technician getTechnicianByTechnicianId(Long id);

    public Technician getTechnicianByUserId(Long id);

    // get list of all technicians in the department
    public List<Technician> getTechniciansByDept(Long id);

    // get list of how many tickets ea technician has and assign to the one with least
    // assign tickets to the technician from the department to be done in ticket dao
    // responding to tickets to be done in response

}
