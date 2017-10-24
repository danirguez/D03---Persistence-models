package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
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
import org.springframework.format.annotation.DateTimeFormat;

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
	private Collection<String> requirement;
	private Date publication;
	private Date tripStart;
	private Date tripEnd;

	private final Integer VAT_TAX = 21;

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
		Double price = 0.;
		
		for(Stage g: stage) {
			price = g.getPrice() + price;
		}
		price = price + (price*VAT_TAX)/100;
		return price;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getPublication() {
		return publication;
	}

	public void setPublication(Date publication) {
		this.publication = publication;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getTripStart() {
		return tripStart;
	}

	public void setTripStart(Date tripStart) {
		this.tripStart = tripStart;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getTripEnd() {
		return tripEnd;
	}

	public void setTripEnd(Date tripEnd) {
		this.tripEnd = tripEnd;
	}
	
	// Relationships

	private LegalText legalText;
	private Ranger ranger;
	private Collection<Survival> survival;
	private Manager manager;
	private Audit audit;
	private Collection<Note> note;
	private Collection<Sponsorship> sponsorship;
	private Collection<Story> story;
	private Collection<Tag> tag;
	private Collection<Stage> stage;
	private Collection<Category> category;
	private Application application;
	
	@Valid
	@ManyToOne(optional = false)
	@NotNull
	public LegalText getLegalText() {
		return legalText;
	}

	public void setLegalText(LegalText legalText) {
		this.legalText = legalText;
	}

	@Valid
	@ManyToOne(optional = false)
	@NotNull
	public Ranger getRanger() {
		return ranger;
	}

	public void setRanger(Ranger ranger) {
		this.ranger = ranger;
	}

	@Valid
	@OneToMany(mappedBy = "trip")
	@NotNull
	public Collection<Survival> getSurvival() {
		return survival;
	}

	public void setSurvival(Collection<Survival> survival) {
		this.survival = survival;
	}

	@Valid
	@ManyToOne(optional = false)
	@NotNull
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	@Valid
	@ManyToOne(optional = false)
	@NotNull
	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	@Valid
	@OneToMany(mappedBy = "trip")
	@NotNull
	public Collection<Sponsorship> getSponsorship() {
		return sponsorship;
	}

	public void setSponsorship(Collection<Sponsorship> sponsorship) {
		this.sponsorship = sponsorship;
	}

	@Valid
	@OneToMany(mappedBy = "trip")
	@NotNull
	public Collection<Note> getNote() {
		return note;
	}

	public void setNote(Collection<Note> note) {
		this.note = note;
	}

	@Valid
	@OneToMany(mappedBy = "trip")
	@NotNull
	public Collection<Story> getStory() {
		return story;
	}

	public void setStory(Collection<Story> story) {
		this.story = story;
	}

	@Valid
	@OneToMany(mappedBy = "trip")
	@NotNull
	public Collection<Tag> getTag() {
		return tag;
	}

	public void setTag(Collection<Tag> tag) {
		this.tag = tag;
	}

	@Valid
	@OneToMany(mappedBy = "trip")
	@NotNull
	public Collection<Stage> getStage() {
		return stage;
	}

	public void setStage(Collection<Stage> stage) {
		this.stage = stage;
	}

	@Valid
	@OneToMany(mappedBy = "trip")
	@NotNull
	public Collection<Category> getCategory() {
		return category;
	}

	public void setCategory(Collection<Category> category) {
		this.category = category;
	}

	@Valid
	@OneToOne(optional=false)
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	

}
