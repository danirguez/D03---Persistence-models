package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.transaction.Status;
import javax.validation.Valid;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.PROPERTY)
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

	
	@OneToOne(optional=false, mappedBy="application")
	@Valid
	public Trip getTrip() {
		return trip;//
	}

	public void setCVs(final Trip trip) {
		this.trip = trip;
	}

	@ManyToOne(optional=false)
	@Valid
	public Explorer getExplorer() {
		return explorer;
	}

	public void setExplorer(final Explorer explorer) {//
		this.explorer = explorer;
	}

}
