package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Auditor extends Actor {

	// Constructors

	public Auditor() {
		super();
	}

	// Relationships

	private Collection<Note> note;
	private Collection<Audit> audit;

	@Valid
	@NotNull
	@OneToMany(mappedBy = "auditor")
	public Collection<Note> getNote() {
		return note;
	}

	public void setNote(Collection<Note> note) {
		this.note = note;
	}

	@Valid
	@NotNull
	@OneToMany(mappedBy = "auditor")
	public Collection<Audit> getAudit() {
		return audit;
	}

	public void setAudit(Collection<Audit> audit) {
		this.audit = audit;
	}
}
