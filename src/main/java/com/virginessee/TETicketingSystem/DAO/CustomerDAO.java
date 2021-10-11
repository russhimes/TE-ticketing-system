package com.virginessee.TETicketingSystem.DAO;

import com.virginessee.TETicketingSystem.models.Customer;

public interface CustomerDAO {

    public Customer getCustomerById(Long id);

    public Customer getCustomerByUserId(Long id);

}
