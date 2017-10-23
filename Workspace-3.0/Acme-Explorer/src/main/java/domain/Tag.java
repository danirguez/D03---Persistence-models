package domain;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

public class Tag extends DomainEntity {
	
	private String name;
	
	private Trip trip;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Valid
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
}