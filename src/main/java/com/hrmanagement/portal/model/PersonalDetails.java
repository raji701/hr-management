package com.hrmanagement.portal.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personal_details")
public class PersonalDetails {

	public enum BloodGroup {
		A_POSITIVE, A_NEGATIVE, B_POSITIVE, B_NEGATIVE, AB_POSITIVE, AB_NEGATIVE, O_POSITIVE, O_NEGATIVE
	}

	public enum MaritalStatus {
		SINGLE, MARRIED, DIVORCED, WIDOWED, OTHER
	}

	public enum Gender {
		MALE, FEMALE, OTHER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "employee_id")
	private Integer employeeId;


	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "employee_id",insertable = false, updatable= false)
	private Employee employee;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "place_of_birth", length = 50)
	private String placeOfBirth;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "gender")
	private Gender gender;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "blood_group")
	private BloodGroup bloodGroup;

	@Column(name = "citizenship", length = 20)
	private String citizenship;

	@Column(name = "religion", length = 20)
	private String religion;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "marital_status")
	private MaritalStatus maritalStatus;

	@Column(name = "marriage_date")
	private LocalDate marriageDate;

	@Column(name = "passport_number", length = 15)
	private String passportNumber;

	@Column(name = "aadhar_number", unique = true)
	private Long aadharNumber;

	@Column(name = "pan_card_number", length = 10, unique = true)
	private String panCardNumber;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "modified_at")
	private LocalDateTime modifiedAt;
	
	@Column(name="modified_by")
	private Integer modifiedBy;

	
	
	

}
