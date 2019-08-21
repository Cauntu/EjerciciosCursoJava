package es.eoi.services;

import java.util.List;

public interface MyService<T> {


	public boolean create(T c);
	public T read(T c);
	public T readByID(int id);
	public List<T> readAll();
	public boolean update(T c);
	public boolean delete(T c);
	
	
	
}
