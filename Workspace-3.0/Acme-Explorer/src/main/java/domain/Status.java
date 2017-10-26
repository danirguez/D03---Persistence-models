package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.PROPERTY)
public class Status {

	// Attributes
	
	private static final String PENDING = "PENDING";
	private static final String REJECTED = "REJECTED";
	private static final String DUE = "DUE";
	private static final String ACCEPTED = "ACCEPTED";
	private static final String CANCELLED = "CANCELLED";

	public static String getPending() {
		return PENDING;
	}

	public static String getRejected() {
		return REJECTED;
	}

	public static String getDue() {
		return DUE;
	}

	public static String getAccepted() {
		return ACCEPTED;
	}

	public static String getCancelled() {
		return CANCELLED;
	}
}
