package domain;

import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Note extends DomainEntity {

	private Date moment;
	private String remark;
	private String reply;
	private Date momentReply;

	private Auditor auditor;
	private Collection<Trip> trip;

	@NotEmpty
	@Past
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

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

	@Valid
	public Collection<Trip> getTrip() {
		return trip;//
	}

	public void setCVs(final Collection<Trip> trip) {//
		this.trip = trip;
	}

	@Valid
	public Auditor getAuditor() {
		return auditor;//
	}

	public void setAuditor(final Auditor auditor) {//
		this.auditor = auditor;
	}

}
