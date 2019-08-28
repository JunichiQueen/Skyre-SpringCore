package com.bae.entity;

public class Cases {

	private String citizenId;
	
	private String forenames;
	
	private String surname;
	
	private String homeAddress;
	
	private String dateOfBirth;
	
	private String placeOfBirth;
	
	private String sex;
	
	private String bankAccountId;
	
	private String accountNumber;
	
	private String bank;
	
	private String phoneNumber;
	
	private String network;
	
	private String registrationId;
	
	private String driverLicenceId;
	
	private String vehicleRegistrationNo;
	
	private String registrationDate;
	
	private String make;
	
	private String model;
	
	private String colour;
	
	public Cases(String citizenId, String forenames, String surname, String homeAddress, String dateOfBirth,
			String placeOfBirth, String sex, String bankAccountId, String accountNumber, String bank,
			String phoneNumber, String network, String registrationId, String driverLicenceId,
			String vehicleRegistrationNo, String registrationDate, String make, String model, String colour) {
		super();
		this.citizenId = citizenId;
		this.forenames = forenames;
		this.surname = surname;
		this.homeAddress = homeAddress;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.sex = sex;
		this.bankAccountId = bankAccountId;
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.phoneNumber = phoneNumber;
		this.network = network;
		this.registrationId = registrationId;
		this.driverLicenceId = driverLicenceId;
		this.vehicleRegistrationNo = vehicleRegistrationNo;
		this.registrationDate = registrationDate;
		this.make = make;
		this.model = model;
		this.colour = colour;
	}
	
	public Cases () {
		
	}

	public String getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(String bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getDriverLicenceId() {
		return driverLicenceId;
	}

	public void setDriverLicenceId(String driverLicenceId) {
		this.driverLicenceId = driverLicenceId;
	}

	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}

	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Cases [citizenId=" + citizenId + ", forenames=" + forenames + ", surname=" + surname + ", homeAddress="
				+ homeAddress + ", dateOfBirth=" + dateOfBirth + ", placeOfBirth=" + placeOfBirth + ", sex=" + sex
				+ ", bankAccountId=" + bankAccountId + ", accountNumber=" + accountNumber + ", bank=" + bank
				+ ", phoneNumber=" + phoneNumber + ", network=" + network + ", registrationId=" + registrationId
				+ ", driverlicenceId=" + driverLicenceId + ", vehicleRegistrationNo=" + vehicleRegistrationNo
				+ ", registrationDate=" + registrationDate + ", make=" + make + ", model=" + model + ", colour="
				+ colour + "]";
	}
	
	
	

}
