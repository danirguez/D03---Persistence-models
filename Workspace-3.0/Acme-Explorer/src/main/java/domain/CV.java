package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Access(AccessType.PROPERTY)
public class CV extends DomainEntity {

	//Constructors
	
	public CV() {
		super();
	}
	
	// Attributes
	
	private String ticker;
		
	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "[0-9]{6}-[A-Z]{4}")
	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	// Relationships
	
	private Ranger ranger;
	private PersonalRecord personalRecord;
	private Collection<EndorserRecord> endorserRecord;
	private Collection<MiscellaneousRecord> miscellaneousRecord;
	private Collection<ProfesionalRecord> profesionalRecord;
	private Collection<EducationRecord> educationRecord;

	@Valid
	@OneToOne(optional=false)
	public Ranger getRanger() {
		return ranger;
	}

	public void setRanger(Ranger ranger) {
		this.ranger = ranger;
	}

	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional=false)
	public PersonalRecord getPersonalRecord() {
		return personalRecord;
	}

	public void setPersonalRecord(PersonalRecord personalRecord) {
		this.personalRecord = personalRecord;
	}

	@Valid
	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	@ElementCollection
	public Collection<EndorserRecord> getEndorserRecord() {
		return endorserRecord;
	}

	public void setEndorserRecord(Collection<EndorserRecord> endorserRecord) {
		this.endorserRecord = endorserRecord;
	}

	@Valid
	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	@ElementCollection
	public Collection<MiscellaneousRecord> getMiscellaneousRecord() {
		return miscellaneousRecord;
	}

	public void setMiscellaneousRecord(Collection<MiscellaneousRecord> miscellaneousRecord) {
		this.miscellaneousRecord = miscellaneousRecord;
	}

	@Valid
	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	@ElementCollection
	public Collection<ProfesionalRecord> getProfesionalRecord() {
		return profesionalRecord;
	}

	public void setProfesionalRecord(Collection<ProfesionalRecord> profesionalRecord) {
		this.profesionalRecord = profesionalRecord;
	}

	@Valid
	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	@ElementCollection
	public Collection<EducationRecord> getEducationRecord() {
		return educationRecord;
	}

	public void setEducationRecord(Collection<EducationRecord> educationRecord) {
		this.educationRecord = educationRecord;
	}
}
