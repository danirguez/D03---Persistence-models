package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.PROPERTY)
public class Trip extends DomainEntity{
	
	// Constructors
	
	public Trip() {
		super();
	}
	
	// Attributes

	private String ticker;
	private String title;
	private String description;
	private Double price;
	private Collection<String> requirement;
	private Date publication;
	private Date tripStart;
	private Date tripEnd;
	private String reason;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "[0-9]{6}-[A-Z]{4}")
	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@NotEmpty
	@ElementCollection
	public Collection<String> getRequirement() {
		return requirement;
	}

	public void setRequirement(Collection<String> requirement) {
		this.requirement = requirement;
	}

	@Min(0)
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPublication() {
		return publication;
	}

	public void setPublication(Date publication) {
		this.publication = publication;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTripStart() {
		return tripStart;
	}

	public void setTripStart(Date tripStart) {
		this.tripStart = tripStart;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTripEnd() {
		return tripEnd;
	}

	public void setTripEnd(Date tripEnd) {
		this.tripEnd = tripEnd;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	// Relationships

	private Ranger ranger;
	private Collection<Survival> survival;
	private Manager manager;
	private Collection<Audit> audit;
	private Collection<Note> note;
	private Collection<Sponsorship> sponsorship;
	private Collection<Story> story;
	private Collection<Tag> tag;
	private Collection<Stage> stage;
	private Collection<Category> category;
	private Collection<Application> application;
	private LegalText legalText;
	
	@Valid
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	public LegalText getLegalText() {
		return legalText;
	}

	public void setLegalText(LegalText legalText) {
		this.legalText = legalText;
	}

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Ranger getRanger() {
		return ranger;
	}

	public void setRanger(Ranger ranger) {
		this.ranger = ranger;
	}

	@Valid
	@NotNull
	@OneToMany(mappedBy = "trip")
	@ElementCollection
	public Collection<Survival> getSurvival() {
		return survival;
	}

	public void setSurvival(Collection<Survival> survival) {
		this.survival = survival;
	}

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	@Valid
	@NotNull
	@OneToMany(mappedBy="trip")
	@ElementCollection
	public Collection<Audit> getAudit() {
		return audit;
	}

	public void setAudit(Collection<Audit> audit) {
		this.audit = audit;
	}

	@Valid
	@NotEmpty
	@ManyToMany(mappedBy = "trips")
	@ElementCollection
	public Collection<Sponsorship> getSponsorship() {
		return sponsorship;
	}

	public void setSponsorship(Collection<Sponsorship> sponsorship) {
		this.sponsorship = sponsorship;
	}

	@Valid
	@NotNull
	@OneToMany(mappedBy = "trip")
	@ElementCollection
	public Collection<Note> getNote() {
		return note;
	}

	public void setNote(Collection<Note> note) {
		this.note = note;
	}

	@Valid
	@NotNull
	@OneToMany(mappedBy = "trip")
	@ElementCollection
	public Collection<Story> getStory() {
		return story;
	}

	public void setStory(Collection<Story> story) {
		this.story = story;
	}

	@Valid
	@NotNull
	@OneToMany(mappedBy = "trip")
	@ElementCollection
	public Collection<Tag> getTag() {
		return tag;
	}

	public void setTag(Collection<Tag> tag) {
		this.tag = tag;
	}

	@Valid
	@NotEmpty
	@OneToMany(mappedBy = "trip")
	@ElementCollection
	public Collection<Stage> getStage() {
		return stage;
	}

	public void setStage(Collection<Stage> stage) {
		this.stage = stage;
	}

	@Valid
	@NotEmpty
	@OneToMany(mappedBy = "trip")
	@ElementCollection
	public Collection<Category> getCategory() {
		return category;
	}

	public void setCategory(Collection<Category> category) {
		this.category = category;
	}

	@Valid
	@NotEmpty
	@OneToMany(mappedBy = "trip")
	@ElementCollection
	public Collection<Application> getApplication() {
		return application;
	}

	public void setApplication(Collection<Application> application) {
		this.application = application;
	}

}
