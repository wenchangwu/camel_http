package jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl<PK> implements BaseDao<PK> {
	
	private Class<PK> clazz;

	public BaseDaoImpl(Class<PK> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		clazz = (Class<PK>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@PersistenceContext
	public EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(PK object) {
		this.entityManager.persist(object);
	}

	@Override
	public PK fetchObjectById(int id) {
		return this.entityManager.find(clazz,id);
	}

	@Override
	public void update(PK pk) {
		this.entityManager.merge(pk);
	}

 
}
