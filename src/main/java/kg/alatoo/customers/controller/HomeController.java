package kg.alatoo.customers.controller;

import kg.alatoo.customers.dao.Customers;
import kg.alatoo.customers.rest.CustomersRestController;
import kg.alatoo.customers.service.CustomersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    final
    CustomersRestController customersRestController;

    public HomeController(CustomersRestController customersRestController) {
        this.customersRestController = customersRestController;
    }


    @GetMapping(value = "/")
    public String index(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        boolean isAdmin = authentication.getAuthorities().stream()
//                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
//        if (isAdmin) {
//            return "redirect:/organization/list";
//        }
        return "home";
    }
    
    @GetMapping(value = "/customers")
    public String customers(Model model){
        model.addAttribute("customerList", customersRestController.findAllCustomer());
        return "customers";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("customer", new Customers());
        return "add";
    }
    
    
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
}
