package domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

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
	public Ranger getRanger() {
		return ranger;
	}

	public void setRanger(Ranger ranger) {
		this.ranger = ranger;
	}

	@Valid
	public PersonalRecord getPersonalRecord() {
		return personalRecord;
	}

	public void setPersonalRecord(PersonalRecord personalRecord) {
		this.personalRecord = personalRecord;
	}

	public Collection<EndorserRecord> getEndorserRecord() {
		return endorserRecord;
	}

	public void setEndorserRecord(Collection<EndorserRecord> endorserRecord) {
		this.endorserRecord = endorserRecord;
	}

	public Collection<MiscellaneousRecord> getMiscellaneousRecord() {
		return miscellaneousRecord;
	}

	public void setMiscellaneousRecord(Collection<MiscellaneousRecord> miscellaneousRecord) {
		this.miscellaneousRecord = miscellaneousRecord;
	}

	public Collection<ProfesionalRecord> getProfesionalRecord() {
		return profesionalRecord;
	}

	public void setProfesionalRecord(Collection<ProfesionalRecord> profesionalRecord) {
		this.profesionalRecord = profesionalRecord;
	}

	public Collection<EducationRecord> getEducationRecord() {
		return educationRecord;
	}

	public void setEducationRecord(Collection<EducationRecord> educationRecord) {
		this.educationRecord = educationRecord;
	}
}
