package hu.bme.aut.jpa.jpa_lab.dao;

import hu.bme.aut.jpa.jpa_lab.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao extends AbstractDao<Employee> {

    public EmployeeDao() {
        super(Employee.class);
    }

    public List<Employee> findByJobAndSalaryRange(String keyword, int minSalary, int maxSalary) {

        return em.createQuery("""
            select e
            from Employee e
            where lower(e.job) like lower(:keyword)
            and e.salary between :minSalary and :maxSalary
            """, Employee.class)
                .setParameter("keyword", "%" + keyword + "%")
                .setParameter("minSalary", minSalary)
                .setParameter("maxSalary", maxSalary)
                .getResultList();
    }

    /*
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
    */
}
