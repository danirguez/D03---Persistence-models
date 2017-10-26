package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Message extends DomainEntity {

	private Date moment;
	private String subject;
	private String body;
	private Priority priority;

	private Actor sender;
	private Collection<Actor> recipient;
	private Collection<Folder> folder;


	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	@NotBlank
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@NotBlank
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Valid
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	
	/* Actor */
	
	@NotBlank
	@ManyToOne(optional = false)
	public Actor getSender() {
		return sender;
	}

	public void setSender(Actor sender) {
		this.sender = sender;
	}

	@NotBlank
	@OneToMany //TODO: mappedBy??
	public Collection<Actor> getRecipient() {
		return recipient;
	}

	public void setRecipient(Collection<Actor> recipient) {
		this.recipient = recipient;
	}

	
	
	/* Folder */
	
	@Valid
	@ManyToMany
	public Collection<Folder> getFolder() {
		return folder;
	}

	public void setFolder(Collection<Folder> folder) {
		this.folder = folder;
	}
}
