package br.com.fateccommerce.DAO;

import java.util.List;

public interface GenericDAO {

	public abstract Boolean save(Object object);

	public abstract List<Object> findAll();

	public abstract void deleteById(Integer idObject);

	public abstract Object findById(Integer idObject);

	public abstract Boolean update(Object object);

}
