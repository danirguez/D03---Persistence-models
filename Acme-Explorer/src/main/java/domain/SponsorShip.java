package domain;

import java.util.Collection;

import javax.validation.Valid;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

public class SponsorShip extends DomainEntity{

	private String banner;
	private String infoPage;
	private CC creditCard;
	
	private Sponsor sponsor;
	private Collection<Trip> trips;
	

	@URL
	@NotBlank
	public String getBanner(){
		return banner;
	}
	
	public void setBanner(String banner){
		this.banner = banner;
	}
	
	@URL
	@NotBlank
	public String getInfoPage(){
		return infoPage;
	}
	
	public void setInfoPage(String infoPage){
		this.infoPage = infoPage;
	}
	
	@CreditCardNumber
	@NotEmpty
	public CC getCreditCard(){
		return creditCard;
	}
	
	public void setCreditCard(CC creditCard) {
		this.creditCard = creditCard;
	}
	
	@Valid
	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	@Valid
	public Collection<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Collection<Trip> trips) {
		this.trips = trips;
	}
}
