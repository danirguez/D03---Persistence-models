
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Ranger extends Actor {

	private CV	cv;
	private Trip trip;

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
	@OneToOne(mappedBy="ranger", optional=false)
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

}
