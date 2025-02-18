package gestConges.data.dao;

public interface DAO<T> {

	public abstract T create(T entity);
	public abstract T findById(int id);
	public abstract T update(T entity);
	public abstract void delete(T entity);
	
}
