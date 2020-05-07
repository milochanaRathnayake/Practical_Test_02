package com.healthcare.hospitalapi.DAOImple;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.healthcare.hospitalapi.DAO.HospitalDAO;
import com.healthcare.hospitalapi.database.DBconnection;
import com.healthcare.hospitalapi.domain.AppointmentRoom;
import com.healthcare.hospitalapi.domain.Hospital;

public class HospitalDAOImple implements HospitalDAO {
private Connection dBconnection;
	
	
	public HospitalDAOImple() {
		this.dBconnection = DBconnection.getDBconnection().connection;
	}

	@Override
	public List<Hospital> findAll() {
		List<Hospital> hospitals = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = this.dBconnection.prepareStatement("SELECT hospital_id, name, address, phone, email FROM paf.hospital;");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Hospital hospital = new Hospital(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				hospitals.add(hospital);
			}
			preparedStatement.close();
			resultSet.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hospitals;
	}

	@Override
	public boolean createHospital(Hospital hospital) {
		int hospital_id = 0;
		boolean state = false;
		try {
			PreparedStatement preparedStatement = this.dBconnection.prepareStatement("SELECT MAX(hospital_id) FROM paf.hospital;");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next() == false) {
				
			}else {
				resultSet.first();
				hospital_id = resultSet.getInt(1)+1;
				
				PreparedStatement statement = dBconnection.prepareStatement("INSERT INTO paf.hospital VALUES(?, ?, ?, ?, ?, 1);");
				statement.setInt(1, hospital_id);
				statement.setString(2, hospital.getName());
				statement.setString(3, hospital.getAddress());
				statement.setString(4, hospital.getPhone());
				statement.setString(5, hospital.getEmail());
				
				if(statement.executeUpdate() > 0)  state = true;
				
				preparedStatement.close();
				statement.close();
				resultSet.close();
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean updateHospital(Hospital hospital) {
		boolean state = false;
		try {
			PreparedStatement statement = this.dBconnection.prepareStatement("UPDATE paf.hospital SET name = ?, address = ?, phone = ?, email = ? WHERE hospital_id = ?");
			statement.setString(1, hospital.getName());
			statement.setString(2, hospital.getAddress());
			statement.setString(3, hospital.getPhone());
			statement.setString(4, hospital.getEmail());
			statement.setInt(5, hospital.getHospital_id());
			
			if(statement.executeUpdate()>0)
				state = true;
			
			statement.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return state;
	}

	@Override
	public boolean deleteHospital(int id) {
		boolean state = false;
		try {
			PreparedStatement statement = this.dBconnection.prepareStatement("UPDATE paf.hospital SET active = 0 WHERE hospital_id = ?");
			statement.setInt(1, id);

			if(statement.executeUpdate()> 0) state = true;
			statement.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return state;
	}

	@Override
	public Hospital findById(int id) {
		try {
			PreparedStatement preparedStatement = this.dBconnection.prepareStatement("SELECT hospital_id, name, address, phone, email FROM paf.hospital WHERE hospital_id = ?;");
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.first();
			Hospital hospital = new Hospital(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
			preparedStatement.close();
			resultSet.close();
			return hospital;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean createAppointmentRoom(AppointmentRoom appointmentRoom) {
		boolean state = false;
		try {
			PreparedStatement statement = this.dBconnection.prepareStatement("INSERT INTO paf.appointment_room VALUES(?,?,?)");
			statement.setString(1, appointmentRoom.getAppointment_room_id());
			statement.setString(2, appointmentRoom.getDescription());
			statement.setInt(3, appointmentRoom.getHospital_id());

			if(statement.executeUpdate()> 0) state = true;
			statement.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return state;
	}

	@Override
	public AppointmentRoom findByRoomId(String id) {
		AppointmentRoom appointmentRoom = null;
		try {
			PreparedStatement statement = this.dBconnection.prepareStatement("SELECT hospital_id, appointment_room_id, description FROM paf.appointment_room WHERE appointment_room_id = ?");
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();
			resultSet.first();
			appointmentRoom = new AppointmentRoom(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			resultSet.close();
			statement.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return appointmentRoom;
	}
}
