package domain;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

public class Category extends DomainEntity {
	
	private String name;
	
	private Category categoryParent;
	private Trip trip;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Valid
	public Category getCategoryParent() {
		return categoryParent;
	}

	public void setCategoryParent(Category categoryParent) {
		this.categoryParent = categoryParent;
	}

	@Valid
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
}
