package domain;

import java.util.Collection;
import javax.validation.Valid;

public class Auditor extends Actor {

	public Auditor() {
		super();
	}

	private Collection<Note> note;
	private Collection<Audit> audit;

	@Valid
	public Collection<Note> getNote() {
		return note;
	}
	
	public void setNote(Collection<Note> note) {
		this.note = note;
	}

	@Valid
	public Collection<Audit> getAudit() {
		return audit;
	}

	public void setAudit(Collection<Audit> audit) {
		this.audit = audit;
	}
}
