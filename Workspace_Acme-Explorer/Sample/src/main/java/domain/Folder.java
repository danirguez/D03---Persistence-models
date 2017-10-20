package domain;

import java.util.Collection;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

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

	@Valid
	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}

	
	@Valid
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	@Valid
	public Folder getCustomFolder() {
		return customFolder;
	}

	public void setCustomFolder(Folder customFolder) {
		this.customFolder = customFolder;
	}
	
}
