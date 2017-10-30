package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Sponsor extends Actor {

	// Constructors

	public Sponsor() {
		super();
	}

	// Relationships

	private Collection<Sponsorship> sponsorship;

	@Valid
	@NotNull
	@OneToMany(mappedBy = "sponsor")
	public Collection<Sponsorship> getSponsorship() {
		return sponsorship;
	}

	public void setSponsorship(Collection<Sponsorship> sponsorship) {
		this.sponsorship = sponsorship;
	}
}
