package control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Adress;
import entities.Contact;
import entities.Phone;
import entities.User;
import util.SessionUtil;

@ManagedBean(name = "ContactBean")
@SessionScoped
public class ContactBean {
	
	private User currentUser;
	private Contact newContact;
	private Phone newPhone;
	private Adress newAdress;
	
	private List<Phone> listPhones;
	private List<Adress> listAdress;
	
	public ContactBean() {
		
		this.currentUser = new User();
		this.newContact = new Contact();
		this.newPhone = new Phone();
		this.newAdress = new Adress();
		
		this.listPhones = new ArrayList<Phone>();
		this.listAdress = new ArrayList<Adress>();
		
		getCurrentUser();
	}
	
	
	
	private void getCurrentUser() {
		Object obj = SessionUtil.getParam("logged");
		this.currentUser  = (User) obj;
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

	public void setNewAdress(Adress newAdress) {
		this.newAdress = newAdress;
	}
}
