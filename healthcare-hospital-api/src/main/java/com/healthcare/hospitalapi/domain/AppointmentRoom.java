package com.healthcare.hospitalapi.domain;

public class AppointmentRoom {
	private int hospital_id;
	private String appointment_room_id;
	private String description;
	
	
	public AppointmentRoom() {
	}
	
	public AppointmentRoom(int hospital_id, String appointment_room_id, String description) {
		this.hospital_id = hospital_id;
		this.appointment_room_id = appointment_room_id;
		this.description = description;
	}
	
	public int getHospital_id() {
		return hospital_id;
	}

	public String getAppointment_room_id() {
		return appointment_room_id;
	}
	
	public String getDescription() {
		return description;
	}
}
