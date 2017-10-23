package domain;

import java.util.Collection;

import javax.validation.Valid;

public class Explorer extends Actor{

	private Finder finder;
	private EmergencyList emergencyList;
	private Collection<Story> stories;
	private Trip trip;
	private Application application;
	
	public Explorer() {
		super();
	}
	
	@Valid
	public Finder getFinder(){
		return finder;
	}
	
	public void setFinder(Finder finder){
		this.finder = finder;
	}
	
	@Valid
	public EmergencyList getEmergencyList(){
		return emergencyList;
	}
	
	public void setEmergencyList(EmergencyList emergencyList){
		this.emergencyList = emergencyList;
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
