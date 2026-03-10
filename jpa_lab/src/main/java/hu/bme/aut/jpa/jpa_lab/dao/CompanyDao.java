package hu.bme.aut.jpa.jpa_lab.dao;

import hu.bme.aut.jpa.jpa_lab.enitity.Company;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDao {
    @PersistenceContext
    private EntityManager em;
    @Transactional
    public Company create(Company company) {
        em.persist(company);
        return company;
    }
    @Transactional
    public Company update(Company company) {
        return em.merge(company);
    }
    @Transactional
    public void deleteById(Long id) {
        Company company = em.find(Company.class, id);
        em.remove(company);
    }

    @Transactional
    public List<Company> findAllWithEmployees(Long id) {
        /*Company company = em.find(Company.class, id);
        company.getEmployees().size();
        return company;*/

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Company> cq = cb.createQuery(Company.class);
        Root<Company> root = cq.from(Company.class);
        cq.select(root);//.where(cb.equal(root.get("id"), id));
        root.fetch("employees",  JoinType.LEFT);
        return em.createQuery(cq).getResultList();
    }

    public Company findById(Long id) {
        return em.find(Company.class, id);
    }
    public List<Company> findAll() {
        return em.createQuery("select c from Company c",
                Company.class).getResultList();
    }
}