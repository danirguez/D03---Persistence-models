package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.PROPERTY)
public enum Status {

	PENDING, REJECTED, DUE, ACCEPTED, CANCELLED;
}
