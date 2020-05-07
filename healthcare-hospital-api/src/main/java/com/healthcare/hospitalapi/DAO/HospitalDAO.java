package com.healthcare.hospitalapi.DAO;

import java.util.List;

import com.healthcare.hospitalapi.domain.AppointmentRoom;
import com.healthcare.hospitalapi.domain.Hospital;

public interface HospitalDAO {

	List<Hospital> findAll();

	boolean createHospital(Hospital hospital);

	boolean updateHospital(Hospital hospital);

	boolean deleteHospital(int id);

	Hospital findById(int id);

	boolean createAppointmentRoom(AppointmentRoom appointmentRoom);
	
	AppointmentRoom findByRoomId(String id);
}
