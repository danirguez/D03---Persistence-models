package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Manager extends Actor {

	public Manager() {
		super();
	}

	private Collection<Survival> survival;
	private Collection<Trip> trip;

	@OneToMany(mappedBy="manager")
	@Valid
	public Collection<Survival> getSurvival() {
		return this.survival;
	}

	public void setSurvival(final Collection<Survival> survival) {
		this.survival = survival;
	}

	@OneToMany(mappedBy="manager")
	@Valid
	public Collection<Trip> getTrip() {
		return this.trip;
	}

	public void setCVs(final Collection<Trip> trip) {
		this.trip = trip;
	}
}
