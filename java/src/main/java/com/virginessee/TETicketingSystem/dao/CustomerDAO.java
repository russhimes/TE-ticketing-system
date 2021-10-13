package com.virginessee.TETicketingSystem.dao;

import com.virginessee.TETicketingSystem.model.Customer;

public interface CustomerDAO {

    public Customer getCustomerById(Long id);

    public Customer getCustomerByUserId(Long id);

}
