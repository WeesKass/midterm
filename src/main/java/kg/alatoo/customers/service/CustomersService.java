package kg.alatoo.customers.service;

import kg.alatoo.customers.dao.Customers;
import kg.alatoo.customers.model.CustomersModel;

import java.util.List;

public interface CustomersService {
    CustomersModel findById(Long id);
    CustomersModel findByFirstName(String firstName);
    CustomersModel findByLastName(String lastName);
    CustomersModel findByEmail(String email);
    CustomersModel mapToModel(Customers customers);
    List<CustomersModel> findAll();
    CustomersModel save(Customers customers);
    void deleteById(Long id);
}
