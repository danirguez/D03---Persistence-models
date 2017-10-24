package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Sponsor extends Actor{


	//Constructors
	
	public Sponsor(){
		super();
	}
	
	// Relationships
	
	private Sponsorship sponsorship;
	
	@Valid
	@OneToOne(mappedBy="Sponsorship",optional=false)
	public Sponsorship getSponsorship() {
		return sponsorship;
	}

	public void setSponsorship(Sponsorship sponsorship) {
		this.sponsorship = sponsorship;
	}
}
