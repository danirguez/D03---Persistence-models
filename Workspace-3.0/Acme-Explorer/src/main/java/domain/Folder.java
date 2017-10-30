package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Folder extends DomainEntity {

	// Constructors

	public Folder() {
		super();
	}

	// Attributes

	private String name;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Relationships

	private Collection<Message> messages;
	private Actor actor;
	private Folder customFolder;
	private Collection<Folder> folders;

	@Valid
	@ManyToMany(mappedBy = "folder")
	@NotNull
	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}

	@Valid
	@ManyToOne(optional = false)
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	@Valid
	@ManyToOne(optional = true)
	public Folder getCustomFolder() {
		return customFolder;
	}

	public void setCustomFolder(Folder customFolder) {
		this.customFolder = customFolder;
	}

	
	@Valid
	@OneToMany(mappedBy="customFolder")
	public Collection<Folder> getFolders() {
		return folders;
	}

	public void setFolders(Collection<Folder> folders) {
		this.folders = folders;
	}

}
