package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Sponsor extends Actor{


	//Constructors
	
	public Sponsor(){
		super();
	}
	
	// Relationships
	
	private SponsorShip sponsorShip;
	
	@Valid
	public SponsorShip getSponsorShip() {
		return sponsorShip;
	}

	public void setSponsorShip(SponsorShip sponsorShip) {
		this.sponsorShip = sponsorShip;
	}
}
