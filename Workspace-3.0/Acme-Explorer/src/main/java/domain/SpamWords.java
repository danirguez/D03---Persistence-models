package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class SpamWords extends DomainEntity {

	// Constructors

	public SpamWords() {
		super();
		words = new ArrayList<String>();
	}

	// Attributes

	private Collection<String> words;

	public Collection<String> getWords() {
		return words;
	}

	public void setWords(Collection<String> words) {
		this.words = words;
	}

}
