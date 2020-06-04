package entities;

import java.util.ArrayList;
import java.util.List;

public class Contact {

	private Long id;		//	Wrapper class ADICIONA FUNCIONALIDADE A VARIÁVEL
	private String name;
	private String lastname;
	private String email;
	
	private User user;
	
	private List<Phone> phones = new ArrayList<Phone>();		//	LISTA INICIALIZA QUANDO O OBJETO É INSTACIADO
	private List<Adress> adresses = new ArrayList<Adress>();		
	
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Phone> getPhones() {
		return phones;
	}
	
	public List<Adress> getAdresses() {
		return adresses;
	}
	
	/*	
	 *	MÉTODOS SET REMOVIDOS PARA EVITAR QUE A LISTA SEJA TROCADA EM ALGUM MOMENTO
	 */
}
