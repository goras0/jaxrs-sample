package se.seb.jaxrs.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import se.seb.jaxrs.clients.CustomerClient;

@Path("/")
public class RootResource {

	@GET
	public String root(){
		CustomerClient client = new CustomerClient();
		
		return client.callService();
	}
}
