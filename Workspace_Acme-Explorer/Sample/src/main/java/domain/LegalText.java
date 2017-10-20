package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class LegalText extends DomainEntity {

	private String title;
	private String body;
	private Collection<Integer> numberLaw;
	private Date moment;

	private Trip trip;

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotBlank
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@NotEmpty
	public Collection<Integer> getNumberLaw() {
		return numberLaw;
	}

	@NotEmpty
	public void setNumberLaw(Collection<Integer> numberLaw) {
		this.numberLaw = numberLaw;
	}

	@Past
	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	@Valid
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
}