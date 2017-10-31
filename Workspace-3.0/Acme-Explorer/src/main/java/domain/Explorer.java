package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.PROPERTY)
public class Explorer extends Actor {

	// Constructors

	public Explorer() {
		super();
	}

	// Relationships

	private Collection<Finder> finder;
	private Collection<Emergency> emergency;
	private Collection<Story> stories;
	private Application application;

	@Valid
	@NotNull
	@OneToMany
	public Collection<Finder> getFinder() {
		return finder;
	}

	public void setFinder(Collection<Finder> finder) {
		this.finder = finder;
	}

	@Valid
	@NotEmpty
	@OneToMany
	public Collection<Emergency> getEmergency() {
		return emergency;
	}

	public void setEmergency(Collection<Emergency> emergency) {
		this.emergency = emergency;
	}

	@Valid
	@OneToMany(mappedBy = "writer")
	public Collection<Story> getStories() {
		return stories;
	}

	public void setStories(Collection<Story> stories) {
		this.stories = stories;
	}

	@Valid
	@NotNull
	@OneToOne(optional = false)
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
}
