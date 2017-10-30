package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class SocialId extends DomainEntity {

	// Constructors

	public SocialId() {
		super();
	}

	// Attributes

	private String photo;
	private String nick;
	private String nameSocialNetwork;
	private String socialNetwork;

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

	@URL
	@NotBlank
	public String getSocialNetwork() {
		return socialNetwork;
	}

	public void setSocialNetwork(String socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

	// Relationships

	private Actor actor;

	@ManyToOne(optional = false)
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

}
