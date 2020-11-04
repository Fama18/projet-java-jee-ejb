package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metier.entities.Village;

@Stateless
public class VillageImpl implements IVillage {
	
	private EntityManager em;
	
	public VillageImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("senforage");
		em = emf.createEntityManager();	
	}

	@Override
	public int add(Village village) {
		try {
			em.getTransaction().begin();
			em.persist(village);
			em.getTransaction().commit();
			return 1;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Village> list() {
		return em.createQuery("SELECT v FROM Village v").getResultList();
	}

	@Override
	public Village getVillageById(int id) {
		return (Village) em.createQuery("SELECT v FROM Village v WHERE v.id=:id").setParameter("id", id).getSingleResult();
	}

}
