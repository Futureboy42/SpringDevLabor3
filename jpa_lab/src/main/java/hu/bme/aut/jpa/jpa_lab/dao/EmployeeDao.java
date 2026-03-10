package hu.bme.aut.jpa.jpa_lab.dao;

import hu.bme.aut.jpa.jpa_lab.enitity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Employee create(Employee employee) {
        em.persist(employee);
        return employee;
    }

    @Transactional
    public Employee update(Employee employee) {
        return em.merge(employee);
    }

    public Employee findById(Long id) {
        return em.find(Employee.class, id);
    }

    @Transactional
    public void deleteById(Long id) {
        em.remove(findById(id));
    }

    public List<Employee> findAll() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }
}
