package kg.alatoo.customers.repository;

import kg.alatoo.customers.dao.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepo extends JpaRepository<Customers, Long> {
    Customers findCustomersById(Long id);
    Customers findByFirstName(String firstName);
    Customers findByLastName(String lastName);
    Customers findByEmail(String email);
}
