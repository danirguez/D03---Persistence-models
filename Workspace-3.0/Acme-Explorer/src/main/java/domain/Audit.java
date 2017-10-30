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

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Audit extends DomainEntity {

	// Constructors

	public Audit() {
		super();
	}

	// Attributes

	private Date moment;
	private String title;
	private String description;
	private Collection<String> attachment;

	@Past
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

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

	@ElementCollection
	public Collection<String> getAttachment() {
		return attachment;
	}

	public void setAttachment(Collection<String> attachment) {
		this.attachment = attachment;
	}

	// Relationships

	private Trip trip;
	private Auditor auditor;

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
	@NotNull
	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}

}
