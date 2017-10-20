package domain;

import java.util.Date;

import javax.validation.Valid;

public class Finder extends DomainEntity{

	private String singleKey;
	private Integer priceRange;
	private Date tripDate;
	
	private Explorer explorer;
	
	
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
	
	@Valid
	public Explorer getExplorer(){
		return explorer;
	}
	
	public void setExplorer(Explorer explorer){
		this.explorer = explorer;
	}
}
