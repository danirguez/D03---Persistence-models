package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Explorer extends Actor{
	
	//Constructors
	
	public Explorer() {
		super();
	}
	
	// Relationships
	
	private Finder finder;
	private Collection<Emergency> emergency;
	private Collection<Story> stories;
	private Trip trip;
	private Application application;
	
	@Valid
	public Finder getFinder(){
		return finder;
	}
	
	public void setFinder(Finder finder){
		this.finder = finder;
	}
	
	@Valid
	public Collection<Emergency> getEmergency(){
		return emergency;
	}
	
	public void setEmergency(Collection<Emergency> emergency){
		this.emergency = emergency;
	}
	
	@Valid
	public Collection<Story> getStories(){
		return stories;
	}
	
	public void setStories(Collection<Story> stories){
		this.stories = stories;
	}
	
	@Valid
	public Trip getTrip(){
		return trip;
	}
	
	public void setTrip(Trip trip){
		this.trip = trip;
	}
	
	@Valid
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
}
