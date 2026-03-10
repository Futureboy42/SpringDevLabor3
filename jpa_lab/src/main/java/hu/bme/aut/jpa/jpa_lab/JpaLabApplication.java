package hu.bme.aut.jpa.jpa_lab;

import hu.bme.aut.jpa.jpa_lab.dao.CompanyDao;
import hu.bme.aut.jpa.jpa_lab.dao.EmployeeDao;
import hu.bme.aut.jpa.jpa_lab.enitity.Company;
import hu.bme.aut.jpa.jpa_lab.enitity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class JpaLabApplication implements CommandLineRunner {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyDao companyDao;

    static void main(String[] args) {
        SpringApplication.run(JpaLabApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        /*
        Employee employee =
                new Employee(null, "Cserepes Virág",
                        "HR advisor", 420_000,
                        LocalDateTime.of(2026, 1, 1,
                                8, 0, 0));


        Company company = new Company(null, "ACME Kft.");
        company.getEmployees().add(employee);
        company = companyDao.create(company);

        employee = employeeDao.create(employee);
        System.out.println(employeeDao.findAll());
        employee.setSalary(450_000);
        System.out.println(employeeDao.findAll());
        employeeDao.update(employee);
        System.out.println(employeeDao.findAll());
        employeeDao.deleteById(employee.getId());
        System.out.println(employeeDao.findAll());
        */


        Employee employee =
                new Employee(null, "Cserepes Virág",
                        "HR advisor", 420_000,
                        LocalDateTime.of(2026, 1, 1,
                                8, 0, 0));
        Company company = new Company(null, "ACME Kft.");

        employee.setCompany(company);
        company.getEmployees().add(employee);
        company = companyDao.create(company);

        List<Company> companies = companyDao.findAllWithEmployees(company.getId());

        Company retrievedCompany = companyDao.findById(company.getId());
        System.out.println("Employees of company " + retrievedCompany.getName() + ":" +
                retrievedCompany.getEmployees());


    }
}
