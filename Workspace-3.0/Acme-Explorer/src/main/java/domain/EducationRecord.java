package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class EducationRecord extends DomainEntity{

	//Constructors
	
	public EducationRecord() {
		super();
	}
	
	// Attributes
	
	private String title;
	private Date start;
	private Date end;

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	//En caso de salir Null en End, significará que no ha acabado el período
	@Size(min = 2, max = 2)
	public Collection<Date> getPeriod() {
		Collection<Date> res = new ArrayList<Date>();
		res.add(start);
		res.add(end);
		return res;
	}

	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Temporal(TemporalType.DATE)
	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}
