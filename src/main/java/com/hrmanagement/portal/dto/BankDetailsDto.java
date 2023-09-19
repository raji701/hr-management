package com.hrmanagement.portal.dto;
public class BankDetailsDto {

	private int id;
    private Integer employeeId;
    private String accountNumber;
    private String bankName;
    private String ifscCode;
    private String bankAddress;
    private String accountType;
    private String paymentMode;
    
	public BankDetailsDto(int id ,Integer employeeId, String accountNumber, String bankName, String ifscCode,
			String bankAddress, String accountType, String paymentMode) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.bankAddress = bankAddress;
		this.accountType = accountType;
		this.paymentMode = paymentMode;
	}

	public BankDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	
  
}
