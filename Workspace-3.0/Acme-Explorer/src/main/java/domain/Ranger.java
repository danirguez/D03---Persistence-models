package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.PROPERTY)
public class Ranger extends Actor {

	// Constructors

	public Ranger() {
		super();
	}

	// Relationships

	private CV cv;
	private Collection<Trip> trips;

	@Valid
	@NotNull
	@OneToOne(mappedBy = "ranger", optional = true)
	public CV getCV() {
		return cv;
	}

	public void setCV(CV cv) {
		this.cv = cv;
	}

	@Valid
	@NotEmpty
	@OneToMany(mappedBy = "ranger")
	@ElementCollection
	public Collection<Trip> getTrip() {
		return trips;
	}

	public void setTrip(Collection<Trip> trip) {
		this.trips = trip;
	}

}
