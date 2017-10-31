package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	private Boolean systemFolder;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull
	public Boolean getSystemFolder() {
		return systemFolder;
	}

	public void setSystemFolder(Boolean systemFolder) {
		this.systemFolder = systemFolder;
	}

	// Relationships

	private Collection<Message> messages;
	private Folder customFolder;

	@Valid
	@NotNull
	@ManyToMany(mappedBy = "folder")
	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}

	@Valid
	@ManyToOne(optional = true)
	public Folder getCustomFolder() {
		return customFolder;
	}

	public void setCustomFolder(Folder customFolder) {
		this.customFolder = customFolder;
	}

}
