package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Finder extends DomainEntity{

	//Constructors
	
	public Finder(){
		super();
	}
	
	// Attributes
	
	private String singleKey;
	private Integer priceRange;
	private Date tripDate;
	
	
	public String getSingleKey(){
		return singleKey;
	}
	
	public void setSingleKey(String singleKey){
		this.singleKey = singleKey;
	}
	
	public int getPriceRange() {
		return priceRange;
	}
	
	public void setPriceRange(Integer priceRange){
		this.priceRange = priceRange;
	}
	
	public Date getTripDate(){
		return tripDate;
	}
	
	public void setTripDate(Date tripDate){
		this.tripDate = tripDate;
	}
	
	// Relationships
	
	private Explorer explorer;
	
	@Valid
	@OneToOne(mappedBy="explorer",optional=false)
	public Explorer getExplorer(){
		return explorer;
	}
	
	public void setExplorer(Explorer explorer){
		this.explorer = explorer;
	}
}
