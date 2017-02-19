package se.seb.jaxrs.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import se.seb.jaxrs.clients.PhoneNrClient;

@Path("/")
public class RootResource {

	@GET
	public String root(){
		PhoneNrClient client = new PhoneNrClient();
		client.getPhoneNr("123");
		return "Will trigger the REST client, look in System out for progress...";
	}
}
