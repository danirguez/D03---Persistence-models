package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Access(AccessType.PROPERTY)
public class Application extends DomainEntity {

	// Constructors

	public Application() {
		super();
	}

	// Attributes

	private Date moment;
	private String status;
	private Collection<String> comment;

	@Past
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	@NotNull
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ElementCollection
	public Collection<String> getComment() {
		return comment;
	}

	public void setComment(Collection<String> comment) {
		this.comment = comment;
	}

	// Relationships

	private Trip trip;
	private Explorer explorer;

	@ManyToOne(optional = false)
	@Valid
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@ManyToOne(optional = false)
	@Valid
	public Explorer getExplorer() {
		return explorer;
	}

	public void setExplorer(final Explorer explorer) {
		this.explorer = explorer;
	}

}
