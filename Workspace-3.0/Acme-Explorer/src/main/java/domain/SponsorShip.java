package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Sponsorship extends DomainEntity{

	//Constructors
	
	public Sponsorship(){
		super();
	}
	
	// Attributes
	
	private String banner;
	private String infoPage;
	private CC creditCard;
	

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
	
	// Relationships
	
	private Sponsor sponsor;
	private Collection<Trip> trips;
	
	@Valid
	@OneToOne(optional=false)
	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	@Valid
	@ManyToMany
	public Collection<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Collection<Trip> trips) {
		this.trips = trips;
	}
}
