package domain;

import javax.validation.Valid;

public class Sponsor extends Actor{

	private SponsorShip sponsorShip;

	public Sponsor(){
		super();
	}
	
	@Valid
	public SponsorShip getSponsorShip() {
		return sponsorShip;
	}

	public void setSponsorShip(SponsorShip sponsorShip) {
		this.sponsorShip = sponsorShip;
	}
}
