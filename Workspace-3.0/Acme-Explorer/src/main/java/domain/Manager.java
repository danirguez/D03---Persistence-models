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
public class Manager extends Actor {

	// Constructors

	public Manager() {
		super();
	}
	
	// Attributes
	
	private Boolean suspicious;
	
	@NotNull
	public Boolean getSuspicious() {
		return suspicious;
	}

	public void setSuspicious(Boolean suspicious) {
		this.suspicious = suspicious;
	}

	// Relationships

	private Collection<Survival> survival;
	private Collection<Trip> trip;

	@Valid
	@NotNull
	@OneToMany(mappedBy = "manager")
	public Collection<Survival> getSurvival() {
		return this.survival;
	}

	public void setSurvival(Collection<Survival> survival) {
		this.survival = survival;
	}

	@Valid
	@NotNull
	@OneToMany(mappedBy = "manager")
	public Collection<Trip> getTrip() {
		return this.trip;
	}

	public void setTrip(Collection<Trip> trip) {
		this.trip = trip;
	}

	
}
