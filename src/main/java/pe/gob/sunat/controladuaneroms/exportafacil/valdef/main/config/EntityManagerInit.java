package pe.gob.sunat.controladuaneroms.exportafacil.valdef.main.config;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class EntityManagerInit {
	
	@PersistenceContext(unitName = "dsprad1")
	private EntityManager dsprad1;
	
	@PersistenceContext(unitName = "dcbdsigad")
	private EntityManager dcbdsigad;
	
	@PersistenceContext(unitName = "dsprtu1")
	private EntityManager dsprtu1;
	
	@PersistenceContext(unitName = "dsprta1")
	private EntityManager dsprta1;
	
	@PersistenceContext(unitName = "dsprpu1")
	private EntityManager dsprpu1;
	
	@PersistenceContext(unitName = "dsprde1")
	private EntityManager dsprde1;
	
	@Produces
	@Named("dsprad1")
	public EntityManager createEntityManagerDsprad1() {
		if (dsprad1 == null) {
			return getEntityManager("dsbddpr6");
		}
		return dsprad1;
	}
	
	@Produces
	@Named("dcbdsigad")
	public EntityManager createEntityManagerDcbdsigad() {
		return dcbdsigad;
	}
	
	@Produces
	@Named("dsprtu1")
	public EntityManager createEntityManagerDsprtu1() {
		return dsprtu1;
	}
	
	@Produces
	@Named("dsprta1")
	public EntityManager createEntityManagerDsprta1() {
		return dsprta1;
	}
	
	@Produces
	@Named("dsprpu1")
	public EntityManager createEntityManagerDsprpu1() {
		return dsprpu1;
	}
	
	@Produces
	@Named("dsprde1")
	public EntityManager createEntityManagerDsprde1() {
		return dsprde1;
	}
	
	
	private EntityManager getEntityManager(String unitName) {
		return Persistence.createEntityManagerFactory(unitName).createEntityManager();
	}
}
