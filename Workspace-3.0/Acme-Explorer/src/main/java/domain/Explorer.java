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
public class Explorer extends Actor{
	
	//Constructors
	
	public Explorer() {
		super();
	}
	
	// Relationships
	
	private Finder finder;
	private Collection<Emergency> emergency;
	private Collection<Story> stories;
	private Collection<Application> application;
	
	@Valid
	@OneToOne(optional=false)
	public Finder getFinder(){
		return finder;
	}
	
	public void setFinder(Finder finder){
		this.finder = finder;
	}
	
	@Valid
	@OneToMany
	public Collection<Emergency> getEmergency(){
		return emergency;
	}
	
	@OneToMany
	public void setEmergency(Collection<Emergency> emergency){
		this.emergency = emergency;
	}
	
	@Valid
	@OneToMany(mappedBy="story")
	public Collection<Story> getStories(){
		return stories;
	}
	
	public void setStories(Collection<Story> stories){
		this.stories = stories;
	}
	
	@Valid
	@OneToMany
	public Collection<Application> getApplication() {
		return application;
	}

	public void setApplication(Collection<Application> application) {
		this.application = application;
	}
}
