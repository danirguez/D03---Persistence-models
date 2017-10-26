package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Folder extends DomainEntity{
	
	
	private String name;
	
	private Collection<Message> messages;
	private Actor actor;
	private Folder customFolder;
	

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	/* Message */
	
	@Valid
	@ManyToMany
	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}

	
	/* Actor */
	
	@Valid
	@ManyToOne(optional = false)
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	
	/* Folder */
	
	@Valid
	//TODO: relación hacia ella misma, hace falta poner algo?
	public Folder getCustomFolder() {
		return customFolder;
	}

	public void setCustomFolder(Folder customFolder) {
		this.customFolder = customFolder;
	}
	
}
