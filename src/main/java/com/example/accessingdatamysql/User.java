package com.example.accessingdatamysql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String mob;
	private String fName;
	private String lName;
	private String doj;
	private String panCard;
	private String adharCard;
	private String bankTransactionType;
	private String bankAccountNumber;
	private String bankIFSCCode;
	private String nameAsPerBank;

	private String nomineeName;
	private String nomineeFName;
	private String nomineeLName;
	private String nomineePanCard;
	private String nomineeAadharCard;
	private String nomineeBankAccountNumber;
	private String nomineeBankIFSCCode;
	private String nomineeNameAsPerBank;
	private String lwd;
	private String userAddress;
	private String imagePath;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getNomineeBankAccountNumber() {
		return nomineeBankAccountNumber;
	}

	public void setNomineeBankAccountNumber(String nomineeBankAccountNumber) {
		this.nomineeBankAccountNumber = nomineeBankAccountNumber;
	}

	public String getNomineeBankIFSCCode() {
		return nomineeBankIFSCCode;
	}

	public void setNomineeBankIFSCCode(String nomineeBankIFSCCode) {
		this.nomineeBankIFSCCode = nomineeBankIFSCCode;
	}

	public String getNomineeNameAsPerBank() {
		return nomineeNameAsPerBank;
	}

	public void setNomineeNameAsPerBank(String nomineeNameAsPerBank) {
		this.nomineeNameAsPerBank = nomineeNameAsPerBank;
	}

	public String getBankTransactionType() {
		return bankTransactionType;
	}

	public void setBankTransactionType(String bankTransactionType) {
		this.bankTransactionType = bankTransactionType;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(String adharCard) {
		this.adharCard = adharCard;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getNomineeFName() {
		return nomineeFName;
	}

	public void setNomineeFName(String nomineeFName) {
		this.nomineeFName = nomineeFName;
	}

	public String getNomineeLName() {
		return nomineeLName;
	}

	public void setNomineeLName(String nomineeLName) {
		this.nomineeLName = nomineeLName;
	}

	public String getNomineePanCard() {
		return nomineePanCard;
	}

	public void setNomineePanCard(String nomineePanCard) {
		this.nomineePanCard = nomineePanCard;
	}

	public String getNomineeAadharCard() {
		return nomineeAadharCard;
	}

	public void setNomineeAadharCard(String nomineeAadharCard) {
		this.nomineeAadharCard = nomineeAadharCard;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankIFSCCode() {
		return bankIFSCCode;
	}

	public void setBankIFSCCode(String bankIFSCCode) {
		this.bankIFSCCode = bankIFSCCode;
	}

	public String getNameAsPerBank() {
		return nameAsPerBank;
	}

	public void setNameAsPerBank(String nameAsPerBank) {
		this.nameAsPerBank = nameAsPerBank;
	}

	public String getLwd() {
		return lwd;
	}

	public void setLwd(String lwd) {
		this.lwd = lwd;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
