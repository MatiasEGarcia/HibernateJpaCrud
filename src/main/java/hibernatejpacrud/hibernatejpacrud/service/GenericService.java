package hibernatejpacrud.hibernatejpacrud.service;

import java.util.Collection;

public interface GenericService<T,K> {
	
	public T save(T t);
	
	public T update(T t);
	
	public void delete(T t);
	
	public T get(T t);
	
	public Collection<T> getAll();
}
