
package domain;


import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class MiscellaneousRecord extends DomainEntity {

	private String title;
	private String link;
	private Collection<String> comment;
	
	public MiscellaneousRecord() {
		super();
	}

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@URL
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Collection<String> getComment() {
		return comment;
	}

	public void setComment(Collection<String> comment) {
		this.comment = comment;
	}

}
