package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.User;

@Stateless
public class UserImpl implements IUser{
	
	@PersistenceContext(unitName="testEjbPu")
	private EntityManager em;
	
	public UserImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testEjbPu");
		em = emf.createEntityManager();
	}
		

	@Override
	public int add(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<User> list() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}


	@Override
	public User getUserByEmail(String email, String password) {
		Query query = em.createQuery("select u from User u where u.email=:email AND u.password=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		try {
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	

}
