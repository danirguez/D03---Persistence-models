package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class Finder extends DomainEntity {

	// Constructors

	public Finder() {
		super();
	}

	// Attributes

	private String singleKey;
	private Double minPrice;
	private Double maxPrice;
	private Date start;
	private Date end;
	private Collection<String> result;

	public String getSingleKey() {
		return singleKey;
	}

	public void setSingleKey(String singleKey) {
		this.singleKey = singleKey;
	}

	@Range(min = 0)
	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	@Range(min = 0)
	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	@NotEmpty
	@ElementCollection
	public Collection<String> getResult() {
		return result;
	}

	public void setResult(Collection<String> result) {
		this.result = result;
	}

}
