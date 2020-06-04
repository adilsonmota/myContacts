package entities;

public class Phone {
	
	private Long id;
	private String typ;
	private String oper;
	private String numbr;
	
	private Contact contact;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getNumbr() {
		return numbr;
	}

	public void setNumbr(String numbr) {
		this.numbr = numbr;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
