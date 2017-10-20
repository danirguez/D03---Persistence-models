package domain;

import java.util.Collection;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

public class EmergencyList extends DomainEntity{

	private String name;
	
	private Explorer explorer;
	private Collection<Emergency> emergencies;
	

	@NotBlank
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Valid
	public Explorer getExplorer() {
		return explorer;
	}

	public void setExplorer(Explorer explorer) {
		this.explorer = explorer;
	}

	@Valid
	public Collection<Emergency> getEmergencies() {
		return emergencies;
	}

	public void setEmergencies(Collection<Emergency> emergencies) {
		this.emergencies = emergencies;
	}
}
