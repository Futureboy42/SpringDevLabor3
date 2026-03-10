package hu.bme.aut.jpa.jpa_lab.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String job;
    private int salary;
    private LocalDateTime workStart;

    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Employee(Long id, String name, String job, int salary, LocalDateTime workStart) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.salary = salary;
        this.workStart = workStart;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setWorkStart(LocalDateTime workStart) {
        this.workStart = workStart;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employee() {
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDateTime getWorkStart() {
        return workStart;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", workStart=" + workStart +
                '}';
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}