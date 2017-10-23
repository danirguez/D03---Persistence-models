package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class EducationRecord {

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
