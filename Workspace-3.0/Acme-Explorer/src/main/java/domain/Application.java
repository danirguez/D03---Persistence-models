package domain;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Status;
import javax.validation.Valid;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

public class Application extends DomainEntity {

	private Date moment;
	private Status status;
	private Collection<String> comment;
	
	private Trip trip;
	private Explorer explorer;

	@Past
	@NotEmpty
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	@NotEmpty
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Collection<String> getComment() {
		return comment;
	}

	public void setComment(Collection<String> comment) {
		this.comment = comment;
	}
	
	@Valid
	public Trip getTrip() {
		return trip;//
	}

	public void setCVs(final Trip trip) {
		this.trip = trip;
	}
	
	@Valid
	public Explorer getExplorer() {
		return explorer;
	}

	public void setExplorer(final Explorer explorer) {//
		this.explorer=explorer;
	}

}
