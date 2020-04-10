# midterm
CREDENTIALS:
   * login: user
   * password: password
FEATURES:
 * MySQL Database.
 * Papes (Home, CustomersList, AddCustomers, Login).
 * "Customers" web page to list all existing customers in the DB.
 * "Add customer" form to add new customers to the "Customers" DB.
 * REST call to delete a customer by id to the DB.
 * Spring Security for adding, deleting new customers by using BASIC AUTH USER.
 * Packages (model, dao, controller, service, repository).
 * EXTRA APIs:
    /api/customer/i/{id}      -  GET by CustomerId
    /api/customer/e/{value}   -  GET all by email
    /api/customer/l/{value}   -  GET all by last name
    /api/customer/f/{value}   -  GET all by fisrt name
    /api/customer/all         -  GET all
    /api/customer/{id}        -  GEt delete by CustomerId
 * Views under "resources/templates/" package.
 * SQL file.
