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
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Audit extends DomainEntity {

	//Constructors
	
	public Audit(){
		super();
	}
	
	// Attributes
	
	private Date moment;
	private String title;
	private String description;
	private Collection<String> link;

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

	@NotEmpty
	@URL
	@ElementCollection
	public Collection<String> getLink() {
		return link;
	}

	public void setLink(Collection<String> link) {
		this.link = link;
	}
	
	// Relationships
	
	private Trip trip;
	private Auditor auditor;

	@ManyToOne(optional=false)
	@Valid
	@NotNull
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	@ManyToOne(optional=false)
	@Valid
	@NotNull
	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(final Auditor auditor) {
		this.auditor=auditor;
	}

}
