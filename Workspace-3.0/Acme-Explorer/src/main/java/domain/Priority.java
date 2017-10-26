package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;


@Embeddable
@Access(AccessType.PROPERTY)
public class Priority {

	
	private static final String HIGH = "HIGH";
	private static final String NEUTRAL = "NEUTRAL";
	private static final String LOW = "LOW";
	
	public static String getHigh() {
		return HIGH;
	}

	public static String getNeutral() {
		return NEUTRAL;
	}

	public static String getLow() {
		return LOW;
	}
}
