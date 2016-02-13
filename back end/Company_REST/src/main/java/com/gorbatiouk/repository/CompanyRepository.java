package com.gorbatiouk.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.gorbatiouk.model.Company;

@Repository
public class CompanyRepository {

	@PersistenceContext
	private EntityManager em;

	public Company findById(Integer companyId) {
		String id = companyId.toString();
		return (Company) em.createQuery("SELECT u FROM Company u where u.id = " + id).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Company> findAll() {
		return em.createQuery("SELECT u FROM Company u").getResultList();	
	}
	
	public Company create(Company company) {
		em.persist(company);
		return company;
	}
	
	public Company update(Company company) {
		return em.merge(company);
	}
	
	public void delete(Integer id) {
		Company toRemove = findById(id);
		if (toRemove == null) {
			throw new RuntimeException("Cant find company with given id: " + id);
		}
		em.remove(toRemove);
	}

}
