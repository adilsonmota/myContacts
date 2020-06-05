package dao;

import java.util.List;

import entities.Adress;

public interface AdressDAO {

	public void insert(Adress adress);
	public void update(Adress adress);
	public void remove(Adress adress);
	public List<Adress> findAll();
}
