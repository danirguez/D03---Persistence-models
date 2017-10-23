package domain;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Tag extends DomainEntity {
	
	// Constructors
	
	public Tag() {
		super();
	}
	
	// Attributes
	
	private String name;
	
	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// Relationships
	
	private Trip trip;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
}
