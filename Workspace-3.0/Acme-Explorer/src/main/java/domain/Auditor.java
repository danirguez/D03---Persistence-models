package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Auditor extends Actor {

	public Auditor() {
		super();
	}

	private Collection<Note> note;
	private Collection<Audit> audit;

	@OneToMany(mappedBy="auditor")
	@Valid
	public Collection<Note> getNote() {
		return note;
	}
	
	public void setNote(Collection<Note> note) {
		this.note = note;
	}

	@OneToMany(mappedBy="auditor")
	@Valid
	public Collection<Audit> getAudit() {
		return audit;
	}

	public void setAudit(Collection<Audit> audit) {
		this.audit = audit;
	}
}
