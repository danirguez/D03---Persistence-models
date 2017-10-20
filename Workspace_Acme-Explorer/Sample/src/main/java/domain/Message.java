package domain;

import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Message extends DomainEntity {

	private Actor sender;
	private Collection<Actor> recipient;
	private Date moment;
	private String subject;
	private String body;
	private Priority priority;

	private Collection<Folder> folder;

	@NotBlank
	public Actor getSender() {
		return sender;
	}

	public void setSender(Actor sender) {
		this.sender = sender;
	}

	@NotBlank
	public Collection<Actor> getRecipient() {
		return recipient;
	}

	public void setRecipient(Collection<Actor> recipient) {
		this.recipient = recipient;
	}

	@NotEmpty
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

	@Valid
	public Collection<Folder> getFolder() {
		return folder;
	}

	public void setFolder(Collection<Folder> folder) {
		this.folder = folder;
	}
}
