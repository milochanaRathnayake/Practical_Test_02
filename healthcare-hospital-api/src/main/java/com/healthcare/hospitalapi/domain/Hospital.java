package com.healthcare.hospitalapi.domain;

public class Hospital {
	private int hospital_id;
	private String name;
	private String address; 
	private String phone; 
	private String email;
	
	
	public Hospital() {
		super();
	}

	public Hospital(int hospital_id, String name, String address, String phone, String email) {
		super();
		this.hospital_id = hospital_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public int getHospital_id() {
		return hospital_id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Hospital [hospital_id=" + hospital_id + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + "]";
	}
}
