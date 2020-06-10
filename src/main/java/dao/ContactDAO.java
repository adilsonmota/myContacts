package dao;

import java.util.List;

import entities.Contact;
import entities.User;

public interface ContactDAO {

	public Long insert(Contact contact);
	public void update(Contact contact);
	public void remove(Contact contact);
	public List<Contact> findAll();
	public List<Contact> searchContact(User user, String keyword);
}
