package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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
public class Trip extends DomainEntity {

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
	@Temporal(TemporalType.DATE)
	public Date getPublication() {
		return publication;
	}

	public void setPublication(Date publication) {
		this.publication = publication;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	public Date getTripStart() {
		return tripStart;
	}

	public void setTripStart(Date tripStart) {
		this.tripStart = tripStart;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
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
	private Collection<Story> story;
	private Collection<Stage> stage;
	private Category category;
	private LegalText legalText;
	private Application application;
	private Collection<Audit> audit;
	private Collection<Note> note;
	private Collection<Value> value;

	@Valid
	@OneToOne(optional = true)
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
	@OneToMany(mappedBy = "trip")
	public Collection<Story> getStory() {
		return story;
	}

	public void setStory(Collection<Story> story) {
		this.story = story;
	}

	@Valid
	@OneToMany(mappedBy = "trip")
	public Collection<Value> getValue() {
		return value;
	}

	public void setValue(Collection<Value> value) {
		this.value = value;
	}

	@Valid
	@NotEmpty
	@OneToMany(mappedBy = "trip",cascade = CascadeType.ALL)
	public Collection<Stage> getStage() {
		return stage;
	}

	public void setStage(Collection<Stage> stage) {
		this.stage = stage;
	}

	@Valid
	@ManyToOne(optional = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	@Valid
	@NotNull
	@OneToMany(mappedBy = "trip")
	public Collection<Audit> getAudit() {
		return audit;
	}

	public void setAudit(Collection<Audit> audit) {
		this.audit = audit;
	}

	@Valid
	@NotNull
	@OneToMany(mappedBy = "trip")
	public Collection<Note> getNote() {
		return note;
	}

	public void setNote(Collection<Note> note) {
		this.note = note;
	}
}
