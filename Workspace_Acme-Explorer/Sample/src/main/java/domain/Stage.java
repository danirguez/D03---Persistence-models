package domain;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Stage extends DomainEntity {

	private String title;
	private String description;
	private Double price;

	private Trip trip;

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotEmpty
	public Double getPrice() {
		return price;
	}

	@NotEmpty
	public void setPrice(Double price) {
		this.price = price;
	}

	@Valid
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
}