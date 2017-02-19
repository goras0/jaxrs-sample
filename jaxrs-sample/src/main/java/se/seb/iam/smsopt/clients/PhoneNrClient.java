package se.seb.iam.smsopt.clients;

import java.net.URI;

import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import se.seb.iam.smsopt.model.PersonDto;
import se.seb.iam.smsopt.model.PhoneNumber;

public class PhoneNrClient {
	
	/**
	 * Call a resource with a path parameter
	 * 
	 * @param personNr
	 * @return
	 */
	public String getPhoneNr(String personNr){
		Client client = ClientBuilder.newClient();
		PhoneNumber phoneNr = null;
		try{		
			String url = "http://localhost:9080/sms-otp/rest/phoneNr/" + personNr;
		
			phoneNr =  client.target(url)
							 .request(MediaType.APPLICATION_JSON)
							 .get(PhoneNumber.class);	
			
			System.out.println("phoneNr : " + phoneNr.getNumber());
		
			return phoneNr.getNumber();
			
		}catch(NotFoundException | NotAcceptableException ex){
			ex.printStackTrace();
		}finally{
			client.close();
		}
		return "something went wrong...";
	}
			
			
	/**
	 * Call a resource with a JSON payload 
	 * 
	 * { "personNr": "197001011234", "phoneNr": "123456789" }
	 * 		
	 * @param personNr
	 * @param phoneNr
	 * @return location to PhoneNumber resource
	 */
	public String createPhoneNrMapping(String personNr, String phoneNr){
		Client client = ClientBuilder.newClient();
		URI location = null;
		try{
			PersonDto personDto = new PersonDto();
			personDto.setPersonNr(personNr);
			personDto.setPhoneNr(phoneNr);
			
			// Call Back-end service			
			String url = "http://localhost:9080/sms-otp/rest/phoneNr/";
			Response response = client.target(url).request().post(Entity.json(personDto));
					
			System.out.println(response.toString());
			
			if(response.getStatus()!=201){
				System.out.println("failed to post");
			}
			location = response.getLocation();
			System.out.println("Location : " + location.toString());
			response.close();

			return location.toString();
			
		}finally{
			client.close();
		}
	}

}
