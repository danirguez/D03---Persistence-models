
package domain;

import javax.validation.Valid;

public class Ranger extends Actor {

	private CV	cv;
	
	public Ranger() {
		super();
	}

	@Valid
	public CV getCV() {
		return cv;
	}

	public void setCV(CV cv) {
		this.cv = cv;
	}

}
