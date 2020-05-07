package com.healthcare.hospitalapi.serviceimple;

import java.util.List;

import com.healthcare.hospitalapi.DAOImple.HospitalDAOImple;
import com.healthcare.hospitalapi.domain.AppointmentRoom;
import com.healthcare.hospitalapi.domain.Hospital;
import com.healthcare.hospitalapi.service.HospitalService;

public class HospitalServiceImple implements HospitalService{
	private HospitalDAOImple hospitalDAOImple = new HospitalDAOImple();
	@Override
	public List<Hospital> findAll() {
		//TODO Validate
		return hospitalDAOImple.findAll();
	}

	@Override
	public boolean createHospital(Hospital hospital) {
		// TODO Validate
		return hospitalDAOImple.createHospital(hospital);
	}

	@Override
	public boolean updateHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalDAOImple.updateHospital(hospital);
	}

	@Override
	public boolean deleteHospital(int id) {
		// TODO Auto-generated method stub
		return hospitalDAOImple.deleteHospital(id);
	}

	@Override
	public Hospital findById(int id) {
		// TODO Auto-generated method stub
		return hospitalDAOImple.findById(id);
	}

	@Override
	public boolean createAppointmentRoom(AppointmentRoom appointmentRoom) {
		return hospitalDAOImple.createAppointmentRoom(appointmentRoom);
	}

	@Override
	public AppointmentRoom findByRoomId(String id) {
		return hospitalDAOImple.findByRoomId(id);
	}

}
