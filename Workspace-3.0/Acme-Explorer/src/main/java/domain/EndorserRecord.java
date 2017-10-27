
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class EndorserRecord extends DomainEntity {

	//Constructors
	
	public EndorserRecord() {
		super();
	}
	
	// Attributes
	
	private String endorserName;
	private String email;
	private String phoneNumber;
	private String likedln;
	private Collection<String> comment;

	@NotBlank
	public String getEndorserName() {
		return endorserName;
	}

	public void setEndorserName(String endorserName) {
		this.endorserName = endorserName;
	}

	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotBlank
	@Pattern(regexp = "[+][1-9]{1,3} [(][1-9]{1,3}[)] [0-9]{4,}")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@NotBlank
	@URL
	public String getLikedln() {
		return likedln;
	}

	public void setLikedln(String likedln) {
		this.likedln = likedln;
	}

	@ElementCollection
	public Collection<String> getComment() {
		return comment;
	}

	public void setComment(Collection<String> comment) {
		this.comment = comment;
	}

}
