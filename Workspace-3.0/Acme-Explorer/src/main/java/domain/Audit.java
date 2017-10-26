package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Audit extends DomainEntity {

	private Date moment;
	private String title;
	private String description;
	private Collection<String> link;

	private Collection<Trip> trip;
	private Auditor auditor;

	@Past
	@NotEmpty
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

	@URL
	public Collection<String> getLink() {
		return link;
	}

	public void setLink(Collection<String> link) {
		this.link=link;
	}

	@OneToMany(mappedBy="audit")
	@Valid
	public Collection<Trip> getTrip() {
		return trip;
	}

	public void setCVs(final Collection<Trip> trip) {
		this.trip = trip;
	}
	
	@ManyToOne(optional=false)
	@Valid
	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(final Auditor auditor) {
		this.auditor=auditor;
	}

}
