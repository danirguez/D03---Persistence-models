package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.PROPERTY)
public class Story extends DomainEntity {

	// Constructors

	public Story() {
		super();
	}

	// Attributes

	private String title;
	private String pieceText;
	private Collection<String> link;

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotBlank
	public String getPieceText() {
		return pieceText;
	}

	public void setPieceText(String pieceText) {
		this.pieceText = pieceText;
	}

	@NotEmpty
	@ElementCollection
	public Collection<String> getLink() {
		return link;
	}

	public void setLink(Collection<String> link) {
		this.link = link;
	}

	// Relationships

	private Trip trip;
	private Explorer writer;

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Explorer getWriter() {
		return writer;
	}

	public void setWriter(Explorer writer) {
		this.writer = writer;
	}

}
