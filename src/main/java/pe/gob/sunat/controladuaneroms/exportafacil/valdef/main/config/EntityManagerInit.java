package pe.gob.sunat.controladuaneroms.exportafacil.valdef.main.config;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class EntityManagerInit {
	
	@PersistenceContext(unitName = "bdsigad")
	private EntityManager bdsigad;

	@Produces
	@Named("bdsigad")
	public EntityManager createEntityManagerBdsigad() {
		if (bdsigad == null) {
			return getEntityManager("bdsigad");
		}
		return bdsigad;
	}
	
	private EntityManager getEntityManager(String unitName) {
		return Persistence.createEntityManagerFactory(unitName).createEntityManager();
	}
}
