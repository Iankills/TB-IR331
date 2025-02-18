package gestConges.data.dao;

import gestConges.data.model.Conge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class CongeDAO
 */
@Stateless
@LocalBean
public class CongeDAO implements DAO<Conge> {

	@PersistenceContext
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public CongeDAO() {}

	@Override
	public Conge create(Conge entity) 
	{
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public Conge findById(int id) 
	{
			return entityManager.find(Conge.class, id);
	}

	@Override
	public Conge update(Conge conges)
	{
		Conge entity = entityManager.merge(conges);
			return entity;
	}

	@Override
	public void delete(Conge entity)
	{
			entityManager.remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Conge> findAll() {
		Query query = entityManager.createQuery("select conge from Conge conge");
		return (List<Conge>) query.getResultList();
	}

	public List<Conge> findCongeById(int idSalarie) {
		// TODO Auto-generated method stub
		 		Query query = entityManager.createQuery("select conge from Conge conge where conge.idemploye = :idS");
		 		query.setParameter("idS", idSalarie);
		 		List<Conge> l = query.getResultList();
		 		return l;
	}

	public void remove(Conge conges){
		  conges = entityManager.merge(conges);
		  entityManager.remove(conges);
	}
	
	
}
