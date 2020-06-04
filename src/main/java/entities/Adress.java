package entities;

public class Adress {

	private Long id;
	private String place;
	private String numbr;
	private String street;
	private String neighb;
	private String city;
	private String stateOf;
	
	private Contact contact;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNumbr() {
		return numbr;
	}

	public void setNumbr(String numbr) {
		this.numbr = numbr;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighb() {
		return neighb;
	}

	public void setNeighb(String neighb) {
		this.neighb = neighb;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOf() {
		return stateOf;
	}

	public void setStateOf(String stateOf) {
		this.stateOf = stateOf;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
