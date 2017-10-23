package domain;

import java.util.Collection;

import javax.validation.Valid;

public class Manager extends Actor {

	public Manager() {
		super();
	}

	private Collection<Survival> survival;
	private Collection<Trip> trip;

	@Valid
	public Collection<Survival> getSurvival() {
		return this.survival;
	}

	public void setSurvival(final Collection<Survival> survival) {
		this.survival = survival;
	}

	@Valid
	public Collection<Trip> getTrip() {
		return this.trip;
	}

	public void setCVs(final Collection<Trip> trip) {
		this.trip = trip;
	}
}
