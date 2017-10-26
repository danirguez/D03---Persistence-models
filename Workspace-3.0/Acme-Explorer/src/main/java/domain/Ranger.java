
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Ranger extends Actor {

	private CV	cv;
	private Collection<Trip> trips;

	public Ranger() {
		super();
	}

	@Valid
	@OneToOne(mappedBy="ranger", optional=false)
	public CV getCV() {
		return cv;
	}

	public void setCV(CV cv) {
		this.cv = cv;
	}

	@Valid
	@OneToMany
	public Collection<Trip> getTrip() {
		return trips;
	}

	public void setTrip(Collection<Trip> trip) {
		this.trips = trip;
	}

}
