package control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.UserDAO;
import dao.UserDAOImpl;
import entities.User;
import util.GrowlViewBean;

@ManagedBean(name = "UserBean")
@SessionScoped
public class UserBean {
	
	private User newUser;
	private List<User> registeredUsers;
	private UserDAO userDao;

	private GrowlViewBean message;
	
	
	
	public UserBean() {
		this.message = new GrowlViewBean();
		this.newUser = new User();
		this.registeredUsers = new ArrayList<User>();
		this.userDao = new UserDAOImpl();
	}

	
	
	public String registerUser() {
		
		boolean msg = true;
		
		this.registeredUsers = userDao.findAll();
		
		for (User listUsers : registeredUsers) {
			System.out.println(listUsers.getUsername());
			if (listUsers.getUsername().equals(this.newUser.getUsername())) {
				System.out.println(listUsers.getUsername()+"|"+listUsers.getName());
				msg= false;
			}
		}
		
		if (msg) {
			this.userDao.insert(this.newUser);
			this.newUser = new User();
			message.setSuccessMessage("Cadastro realizado com sucesso!");
			message.saveMessage(true);
			return "index.xhtml";
		} else {
			this.newUser = new User();
			message.setErrorMessage("username já está em uso!");
			message.saveMessage(false);
		}
		return null;
	}
	
	
	
	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}
}
