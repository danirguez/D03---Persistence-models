package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Access(AccessType.PROPERTY)
public class CV extends DomainEntity {

	private String ticker;

	private Ranger ranger;
	private PersonalRecord personalRecord;
	private Collection<EndorserRecord> endorserRecord;
	private Collection<MiscellaneousRecord> miscellaneousRecord;
	private Collection<ProfesionalRecord> profesionalRecord;
	private Collection<EducationRecord> educationRecord;

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

	@OneToMany(cascade = CascadeType.ALL)
	public Collection<EndorserRecord> getEndorserRecord() {
		return endorserRecord;
	}

	public void setEndorserRecord(Collection<EndorserRecord> endorserRecord) {
		this.endorserRecord = endorserRecord;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public Collection<MiscellaneousRecord> getMiscellaneousRecord() {
		return miscellaneousRecord;
	}

	public void setMiscellaneousRecord(Collection<MiscellaneousRecord> miscellaneousRecord) {
		this.miscellaneousRecord = miscellaneousRecord;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public Collection<ProfesionalRecord> getProfesionalRecord() {
		return profesionalRecord;
	}

	public void setProfesionalRecord(Collection<ProfesionalRecord> profesionalRecord) {
		this.profesionalRecord = profesionalRecord;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public Collection<EducationRecord> getEducationRecord() {
		return educationRecord;
	}

	public void setEducationRecord(Collection<EducationRecord> educationRecord) {
		this.educationRecord = educationRecord;
	}
}
