package domain;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Emergency extends DomainEntity{

	private String name;
	private String email;
	private String phoneNumber;
	
	private Explorer explorer;
	private EmergencyList emergencyList;
	
	@NotBlank
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	@Pattern(regexp = "[+][1-9]{1,3} [(][1-9]{1,3}[)] [0-9]{4,}")
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	@Valid
	public Explorer getExplorer(){
		return explorer;
	}
	
	public void setExplorer(Explorer explorer){
		this.explorer = explorer;
	}
	
	@Valid
	public EmergencyList getEmergencyList() {
		return emergencyList;
	}

	public void setEmergencyList(EmergencyList emergencyList) {
		this.emergencyList = emergencyList;
	}

}
