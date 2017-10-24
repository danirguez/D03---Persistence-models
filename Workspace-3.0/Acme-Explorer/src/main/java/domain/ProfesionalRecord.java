
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
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class ProfesionalRecord extends DomainEntity {

	private String companyName;
	private Date start;
	private Date endOrActual;
	private String rol;
	private String link;
	private Collection<String> comment;

	@NotBlank
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@NotNull
	@Size(min = 2, max = 2)
	public Collection<Date> getPeriod() {
		Collection<Date> res = new ArrayList<Date>();
		res.add(start);
		res.add(endOrActual);
		return res;
	}

	@NotEmpty
	@Temporal(TemporalType.DATE)
	@Past
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Temporal(TemporalType.DATE)
	public Date getEndOrActual() {
		return endOrActual;
	}

	public void setEndOrActual(Date endOrActual) {
		this.endOrActual = endOrActual;
	}

	@NotBlank
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@URL
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Collection<String> getComment() {
		return comment;
	}

	public void setComment(Collection<String> comment) {
		this.comment = comment;
	}

}
