package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Actor extends DomainEntity {

	// Constructors

	public Actor() {
		super();
	}

	// Attributes

	private String name;
	private String surname;
	private String email;
	private String phoneNumber;
	private String address;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Email
	@NotBlank
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Pattern(regexp = "\\d+")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Relationships

	private UserAccount userAccount;
	private Collection<Folder> Folders;
	private Message received;
	private Collection<Message> sent;
	private Collection<SocialId> socialId;

	@Valid
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Valid
	@NotNull
	@OneToMany
	public Collection<Folder> getFolders() {
		return Folders;
	}

	public void setFolders(Collection<Folder> Folders) {
		this.Folders = Folders;
	}

	@Valid
	@ManyToOne(optional = true)
	public Message getReceived() {
		return received;
	}

	public void setReceived(Message received) {
		this.received = received;
	}

	@Valid
	@OneToMany(mappedBy = "sender")
	public Collection<Message> getSent() {
		return sent;
	}

	public void setSent(Collection<Message> sent) {
		this.sent = sent;
	}

	@OneToMany(mappedBy = "actor")
	public Collection<SocialId> getSocialId() {
		return socialId;
	}

	public void setSocialId(Collection<SocialId> socialId) {
		this.socialId = socialId;
	}
	
}
