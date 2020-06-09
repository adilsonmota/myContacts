package dao;

import java.util.List;

import entities.Contact;

public interface ContactDAO {

	public void insert(Contact contact);
	public void update(Contact contact);
	public void remove(Contact contact);
	public List<Contact> findAll();
	public Long lastId();
}
