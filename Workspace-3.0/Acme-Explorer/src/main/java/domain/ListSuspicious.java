package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class ListSuspicious extends DomainEntity{

	// Constructors
	
	public ListSuspicious(){
		super();
		setSuspicious(new ArrayList<Actor>());
	}
	
	// Attributes
	
	private Collection<Actor> suspicious;
	
	@ElementCollection
	public Collection<Actor> getSuspicious() {
		return suspicious;
	}

	public void setSuspicious(Collection<Actor> suspicious) {
		this.suspicious = suspicious;
	}
	
	
}
