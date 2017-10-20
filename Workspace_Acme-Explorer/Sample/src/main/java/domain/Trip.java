package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Trip extends DomainEntity{

	private String ticker;
	private String title;
	private String description;
	private Collection<String> requirement;
	private Date publication;
	private Date tripStart;
	private Date tripEnd;

	/* Relaciones */

	private LegalText legalText;
	private Ranger ranger;
	private Collection<Survival> survival;
	private Manager manager;
	private Audit audit;
	private Collection<Note> note;
	private Collection<SponsorShip> sponsorShip;
	private Explorer explorer;
	private Collection<Story> story;
	private Collection<Tag> tag;
	private Collection<Stage> stage;
	private Collection<Category> category;
	private Application application;
	
	private final Integer VAT_TAX = 21;

	@NotBlank
	@Valid
	public LegalText getLegalText() {
		return legalText;
	}

	public void setLegalText(LegalText legalText) {
		this.legalText = legalText;
	}

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "[0-9]{6}-[A-Z]{4}")
	@Valid
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

	public Double getPrice() {
		Double price = 0.;
		
		for(Stage g: stage) {
			price = g.getPrice() + price;
		}
		price = price + (price*VAT_TAX)/100;
		return price;
	}

	@NotBlank
	public Collection<String> getRequirement() {
		return requirement;
	}

	public void setRequirement(Collection<String> requirement) {
		this.requirement = requirement;
	}

	@NotEmpty
	public Date getPublication() {
		return publication;
	}

	public void setPublication(Date publication) {
		this.publication = publication;
	}

	@NotEmpty
	public Date getTripStart() {
		return tripStart;
	}

	public void setTripStart(Date tripStart) {
		this.tripStart = tripStart;
	}

	@NotEmpty
	public Date getTripEnd() {
		return tripEnd;
	}

	public void setTripEnd(Date tripEnd) {
		this.tripEnd = tripEnd;
	}

	@Valid
	public Ranger getRanger() {
		return ranger;
	}

	public void setRanger(Ranger ranger) {
		this.ranger = ranger;
	}

	@Valid
	public Collection<Survival> getSurvival() {
		return survival;
	}

	public void setSurvival(Collection<Survival> survival) {
		this.survival = survival;
	}

	@Valid
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	@Valid
	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	@Valid
	public Collection<SponsorShip> getSponsorShip() {
		return sponsorShip;
	}

	public void setSponsorShip(Collection<SponsorShip> sponsorShip) {
		this.sponsorShip = sponsorShip;
	}

	@Valid
	public Collection<Note> getNote() {
		return note;
	}

	public void setNote(Collection<Note> note) {
		this.note = note;
	}

	@Valid
	public Explorer getExplorer() {
		return explorer;
	}

	public void setExplorer(Explorer explorer) {
		this.explorer = explorer;
	}

	@Valid
	public Collection<Story> getStory() {
		return story;
	}

	public void setStory(Collection<Story> story) {
		this.story = story;
	}

	@Valid
	public Collection<Tag> getTag() {
		return tag;
	}

	public void setTag(Collection<Tag> tag) {
		this.tag = tag;
	}

	@Valid
	public Collection<Stage> getStage() {
		return stage;
	}

	public void setStage(Collection<Stage> stage) {
		this.stage = stage;
	}

	@Valid
	public Collection<Category> getCategory() {
		return category;
	}

	public void setCategory(Collection<Category> category) {
		this.category = category;
	}

	@Valid
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	

}
