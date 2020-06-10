package control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.AdressDAO;
import dao.AdressDAOImpl;
import dao.ContactDAO;
import dao.ContactDAOImpl;
import dao.PhoneDAO;
import dao.PhoneDAOImpl;
import entities.Adress;
import entities.Contact;
import entities.Phone;
import entities.User;
import util.SessionUtil;

@ManagedBean(name = "ContactBean")
@SessionScoped
public class ContactBean {
	
	private String keyword;
	
	private User currentUser;
	private Contact newContact;
	private Phone newPhone;
	private Adress newAdress;
	
	private List<Phone> listPhones;
	private List<Adress> listAdress;
	private List<Contact> listContacts;
	
	private ContactDAO contactDao;
	private AdressDAO adressDao;
	private PhoneDAO phoneDao;
	
	public ContactBean() {
		
		this.currentUser = new User();
		this.newContact = new Contact();
		this.newPhone = new Phone();
		this.newAdress = new Adress();
		
		this.listPhones = new ArrayList<Phone>();
		this.listAdress = new ArrayList<Adress>();
		this.listContacts = new ArrayList<Contact>();
		
		this.contactDao = new ContactDAOImpl();
		this.adressDao = new AdressDAOImpl();
		this.phoneDao = new PhoneDAOImpl();
		
		currentUser();
	}
	
	
	public void search() {
		this.listContacts = contactDao.searchContact(currentUser, keyword);
	}
	
	
	private void currentUser() {
		Object obj = SessionUtil.getParam("logged");
		this.currentUser  = (User) obj;
	}

	
    public String reinit() {
    	this.newPhone = new Phone();
		this.newAdress = new Adress();
        return null;
    }
	
    
    public void saveAll() {
   	
    	if (this.newContact.getName() != null) {
    		this.newContact.setUser(this.currentUser);
    		this.newContact.setId(this.contactDao.insert(this.newContact));			
    		
	    	for (Adress adress : listAdress) {
				adress.setContact(this.newContact);
				adressDao.insert(adress);
			}
	    	for (Phone phone : listPhones) {
				phone.setContact(this.newContact);
				phoneDao.insert(phone);
			}
    	}
    	this.newContact = new Contact();
    	this.listAdress = new ArrayList<Adress>();
    	this.listPhones = new ArrayList<Phone>();
    }
    
	
	public List<Phone> getListPhones() {
		return listPhones;
	}

	public List<Adress> getListAdress() {
		return listAdress;
	}

	public Contact getNewContact() {
		return newContact;
	}

	public void setNewContact(Contact newContact) {
		this.newContact = newContact;
	}

	public Phone getNewPhone() {
		return newPhone;
	}

	public void setNewPhone(Phone newPhone) {
		this.newPhone = newPhone;
	}

	public Adress getNewAdress() {
		return newAdress;
	}

	public User getCurrentUser() {
		return currentUser;
	}



	public String getKeyword() {
		return keyword;
	}



	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}



	public List<Contact> getListContacts() {
		return listContacts;
	}
	
}
