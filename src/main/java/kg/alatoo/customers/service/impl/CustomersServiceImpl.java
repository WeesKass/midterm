package kg.alatoo.customers.service.impl;

import kg.alatoo.customers.dao.Customers;
import kg.alatoo.customers.model.CustomersModel;
import kg.alatoo.customers.repository.CustomersRepo;
import kg.alatoo.customers.service.CustomersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersServiceImpl implements CustomersService {

    final
    CustomersRepo customersRepo;

    public CustomersServiceImpl(CustomersRepo customersRepo) {
        this.customersRepo = customersRepo;
    }


    @Override
    public CustomersModel findById(Long id) {
        Customers result = customersRepo.findCustomersById(id);

        return mapToModel(result);
    }

    @Override
    public CustomersModel findByFirstName(String firstName) {
        return mapToModel(customersRepo.findByFirstName(firstName));
    }

    @Override
    public CustomersModel findByLastName(String lastName) {
        return mapToModel(customersRepo.findByLastName(lastName));
    }

    @Override
    public CustomersModel findByEmail(String email) {
        return mapToModel(customersRepo.findByEmail(email));
    }

    @Override
    public CustomersModel mapToModel(Customers customers) {
        CustomersModel model = new CustomersModel();
        model.setId(customers.getId());
        model.setFirstName(customers.getFirstName());
        model.setLastName(customers.getLastName());
        model.setEmail(customers.getEmail());
        model.setPhoneNumber(customers.getPhoneNumber());
        model.setWebPage(customers.getWebPage());
        return model;
    }

    @Override
    public List<CustomersModel> findAll() {
       return customersRepo.findAll().stream().map(this::mapToModel).collect(Collectors.toList());
    }

    @Override
    public CustomersModel save(Customers customers) {
        System.out.println("added");
        return mapToModel(customersRepo.save(customers));
    }

    @Override
    public void deleteById(Long id) {
        customersRepo.deleteById(id);
    }


}
