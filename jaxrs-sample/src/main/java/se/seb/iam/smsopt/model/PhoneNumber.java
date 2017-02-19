package se.seb.iam.smsopt.model;

public class PhoneNumber {
	String number;
	String countryCode;
	
	public PhoneNumber() {
		
	}
	
	public PhoneNumber(String number, String countryCode) {
		super();
		this.number = number;
		this.countryCode = countryCode;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	

}
