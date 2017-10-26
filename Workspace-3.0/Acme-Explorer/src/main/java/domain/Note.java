package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Note extends DomainEntity {

	//Constructors
	
	public Note(){
		super();
	}
	
	// Attributes
	
	private Date moment;
	private String remark;
	private String reply;
	private Date momentReply;

	@NotNull
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	@NotNull
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMomentReply() {
		return momentReply;
	}

	public void setMomentReply(Date momentReply) {
		this.momentReply = momentReply;
	}

	@NotBlank
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
	
	// Relationships
	
	private Auditor auditor;
	private Trip trip;

	@ManyToOne(optional=false)
	@Valid
	@NotNull
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@ManyToOne(optional=false)
	@Valid
	@NotNull
	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(final Auditor auditor) {
		this.auditor = auditor;
	}

}
