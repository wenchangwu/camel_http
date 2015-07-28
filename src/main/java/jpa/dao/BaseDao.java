package jpa.dao;

public interface BaseDao<PK> {

	   public void save(PK pk);
	   
	   public PK fetchObjectById(int id);
	   
	   public void update(PK pk);
		
}
