package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.PROPERTY)
public class EducationRecord {

	private String title;
	private Date start;
	private Date end;

	public EducationRecord() {
		super();
	}

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	//En caso de salir Null en End, significará que no ha acabado el período
	@Size(min = 2, max = 2)
	//@Temporal(TemporalType.DATE)
	public Collection<Date> getPeriod() {
		Collection<Date> res = new ArrayList<Date>();
		res.add(start);
		res.add(end);
		return res;
	}

	@NotEmpty
	@Past
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}
