package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Actor extends DomainEntity {
	
	
	private String name;
	private String surname;
	private String email;
	private String phoneNumber;
	private String address;
	private Integer socialID;
	private String photo;
	private String nick;
	private String nameSocialNetwork;
	private String socialNetwork;

	
	private UserAccount userAccount;
	private Folder inBox;
	private Folder outBox;
	private Folder notificationBox;
	private Folder trashBox;
	private Folder spamBox;
	private Collection<Folder> customFolders;
	
	
	private Message received;
	private Collection<Message> sent;
	
	public Actor(){
		super();
	}
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Pattern(regexp = "[+][1-9]{1,3} [(][1-9]{1,3}[)] [0-9]{4,}")
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
	
	@NotEmpty
	public Integer getSocialID() {
		return socialID;
	}
	public void setSocialID(Integer socialID) {
		this.socialID = socialID;
	}
	@URL
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@NotBlank
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	@NotBlank
	public String getNameSocialNetwork() {
		return nameSocialNetwork;
	}
	public void setNameSocialNetwork(String nameSocialNetwork) {
		this.nameSocialNetwork = nameSocialNetwork;
	}
	
	@NotBlank
	@URL
	public String getSocialNetwork() {
		return socialNetwork;
	}
	public void setSocialNetwork(String socialNetwork) {
		this.socialNetwork = socialNetwork;
	}
	
	
	
	/* UserAcount */
	
	
	//TODO: ¿cómo lo pongo?
	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	public UserAccount getUserAccount(){
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount){
		this.userAccount = userAccount;
	}
	
	
	/* Folder */
	//TODO: Hay que poner @... en cada una de las carpetas?
	
	@Valid
	@OneToOne(mappedBy="actor")
	public Folder getInBox() {
		return inBox;
	}
	public void setInBox(Folder inBox) {
		this.inBox = inBox;
	}
	
	@Valid
	@OneToOne(mappedBy="actor")
	public Folder getOutBox() {
		return outBox;
	}
	public void setOutBox(Folder outBox) {
		this.outBox = outBox;
	}
	
	@Valid
	@OneToOne(mappedBy="actor")
	public Folder getNotificationBox() {
		return notificationBox;
	}
	public void setNotificationBox(Folder notificationBox) {
		this.notificationBox = notificationBox;
	}
	
	@Valid
	@OneToOne(mappedBy="actor")
	public Folder getTrashBox() {
		return trashBox;
	}
	public void setTrashBox(Folder trashBox) {
		this.trashBox = trashBox;
	}
	
	@Valid
	@OneToOne(mappedBy="actor")
	public Folder getSpamBox() {
		return spamBox;
	}
	public void setSpamBox(Folder spamBox) {
		this.spamBox = spamBox;
	}
	
	@Valid
	@OneToMany(mappedBy="actor")
	public Collection<Folder> getCustomFolders() {
		return customFolders;
	}
	public void setCustomFolders(Collection<Folder> customFolders) {
		this.customFolders = customFolders;
	}
	
	
	/* Message */
	
	@Valid
	@ManyToOne(optional = false) //TODO: no sé si está bien
	public Message getReceived() {
		return received;
	}
	public void setReceived(Message received) {
		this.received = received;
	}
	
	@Valid
	@OneToMany(mappedBy="actor")
	public Collection<Message> getSent() {
		return sent;
	}
	public void setSent(Collection<Message> sent) {
		this.sent = sent;
	}
	
	
	
}
