package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Access(AccessType.PROPERTY)
public class Finder extends DomainEntity{

	//Constructors
	
	public Finder(){
		super();
	}
	
	// Attributes
	
	private String singleKey;
	private Double priceRange;
	private Date tripDate;
	
	
	public String getSingleKey(){
		return singleKey;
	}
	
	public void setSingleKey(String singleKey){
		this.singleKey = singleKey;
	}
	
	@Min(0)
	public Double getPriceRange() {
		return priceRange;
	}
	
	public void setPriceRange(Double priceRange){
		this.priceRange = priceRange;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getTripDate(){
		return tripDate;
	}
	
	public void setTripDate(Date tripDate){
		this.tripDate = tripDate;
	}
	
	// Relationships
	
	private Explorer explorer;
	
	@Valid
	@NotNull
	@OneToOne(mappedBy="finder",optional=false)
	public Explorer getExplorer(){
		return explorer;
	}
	
	public void setExplorer(Explorer explorer){
		this.explorer = explorer;
	}
}
