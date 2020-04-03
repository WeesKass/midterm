package kg.alatoo.customers.rest;

import kg.alatoo.customers.dao.Customers;
import kg.alatoo.customers.model.CustomersModel;
import kg.alatoo.customers.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomersRestController {

    @Autowired
    private CustomersService customersService;

    @PostMapping("/")
    public String createCustomer(@ModelAttribute(value = "customer") Customers customerEntity) {

        customersService.save(customerEntity);
        return "redirect:/customers";
    }

    @GetMapping("/i/{id}")
    public ResponseEntity<CustomersModel> findCustomerById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(customersService.findById(id)) ;
    }

    @GetMapping("/f/{value}")
    public CustomersModel findCustomerByEmail(@PathVariable("value")String value){
        return customersService.findByEmail(value);
    }

    @GetMapping("/l/{value}")
    public CustomersModel findCustomerByFirstName(@PathVariable("value")String value){
        return customersService.findByFirstName(value);
    }

    @GetMapping("/all")
    public List<CustomersModel> findAllCustomer(){
        return customersService.findAll();
    }

    @GetMapping("/{id}")
    public String deleteCustomerById(@PathVariable("id") Long id) {
        customersService.deleteById(id);
        return "redirect:/customers";
    }
}