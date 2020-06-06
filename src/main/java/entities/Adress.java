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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((neighb == null) ? 0 : neighb.hashCode());
		result = prime * result + ((numbr == null) ? 0 : numbr.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((stateOf == null) ? 0 : stateOf.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adress other = (Adress) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (neighb == null) {
			if (other.neighb != null)
				return false;
		} else if (!neighb.equals(other.neighb))
			return false;
		if (numbr == null) {
			if (other.numbr != null)
				return false;
		} else if (!numbr.equals(other.numbr))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (stateOf == null) {
			if (other.stateOf != null)
				return false;
		} else if (!stateOf.equals(other.stateOf))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
}
