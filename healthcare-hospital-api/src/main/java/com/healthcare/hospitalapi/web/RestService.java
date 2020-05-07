package com.healthcare.hospitalapi.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;

import com.healthcare.hospitalapi.domain.AppointmentRoom;
import com.healthcare.hospitalapi.domain.Hospital;
import com.healthcare.hospitalapi.serviceimple.HospitalServiceImple;

@Path("/hospital")
public class RestService extends ResourceConfig{
private HospitalServiceImple hospitalService = new HospitalServiceImple();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		System.out.println("OK");
		List<Hospital> hospitals = hospitalService.findAll();
		return Response.ok().entity(hospitals).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(@FormParam("hospital_id") int hospital_id,
							@FormParam("name") String name,
							@FormParam("address") String address,
							@FormParam("phone") String phone,
							@FormParam("email") String email) throws URISyntaxException {
		Hospital hospital = new Hospital(hospital_id,name,address,phone,email);
		boolean state = this.hospitalService.createHospital(hospital);
		return state ? Response.seeOther(new URI("http://localhost:8080/healthcare-hospital-api")).entity(hospital).build() : Response.status(Status.BAD_REQUEST).build();
	}
	
	@POST
	@Path("/room")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postRoom(@FormParam("hospital_id") int hospital_id,
							@FormParam("appointment_room_no") String appointment_room_no,
							@FormParam("description") String description) {
		AppointmentRoom room = new AppointmentRoom(hospital_id, appointment_room_no, description);
		boolean state = this.hospitalService.createAppointmentRoom(room);
		return state ? Response.ok().entity(room).build() : Response.ok("Failed").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response put(@FormParam("hospital_id") int hospital_id,
							@FormParam("name") String name,
							@FormParam("address") String address,
							@FormParam("phone") String phone,
							@FormParam("email") String email) throws URISyntaxException {
		Hospital hospital = new Hospital(hospital_id,name,address,phone,email);
		
		return this.hospitalService.updateHospital(hospital) ? Response.seeOther(new URI("http://localhost:8080/healthcare-hospital-api")).entity(hospital).build() : Response.status(Status.BAD_REQUEST).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@FormParam("hospital_id") int hospital_id) throws URISyntaxException {
		return this.hospitalService.deleteHospital(hospital_id) ? Response.seeOther(new URI("http://localhost:8080/healthcare-hospital-api")).build() : Response.status(Status.BAD_REQUEST).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@javax.ws.rs.PathParam("id") int id) throws URISyntaxException {
		return Response.seeOther(new URI("http://localhost:8080/healthcare-hospital-api")).entity(this.hospitalService.findById(id)).build();
	}
	
	@GET
	@Path("room/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByRoomId(@javax.ws.rs.PathParam("id") String id) throws URISyntaxException {
		return Response.seeOther(new URI("http://localhost:8080/healthcare-hospital-api")).entity(this.hospitalService.findByRoomId(id)).build();
	}
}
