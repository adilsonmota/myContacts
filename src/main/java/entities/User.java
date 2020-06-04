package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private Long id;		//	Wrapper class ADICIONA FUNCIONALIDADE A VARIÁVEL
	private String username;
	private String password;
	private String name;
	
	private List<Contact> contacts = new ArrayList<Contact>();		//	LISTA INICIALIZA QUANDO O OBJETO É INSTACIADO
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getContacts() {
		return contacts;
	}
	
	/*
	 * MÉTODO SET REMOVIDO PARA EVITAR QUE A LISTA SEJA TROCADA EM ALGUM MOMENTO
	 * */
}
