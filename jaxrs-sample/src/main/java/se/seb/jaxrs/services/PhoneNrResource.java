package se.seb.jaxrs.services;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import se.seb.jaxrs.model.PersonDto;
import se.seb.jaxrs.model.PhoneNumber;

@javax.ws.rs.Path("/phoneNr")
public class PhoneNrResource {
	
	static final Map<String, PhoneNumber> map = new ConcurrentHashMap<String, PhoneNumber>();
	
	static{
		map.put("123", new PhoneNumber("118118","46"));
	}
	
	@GET
	@Path("{pnr}")
	@Produces(MediaType.APPLICATION_JSON)	
	public javax.ws.rs.core.Response getPhoneNr(@Context UriInfo uriInfo, @javax.ws.rs.core.Context HttpHeaders requestHeaders, @javax.ws.rs.PathParam("pnr") String pnr){
		System.out.println("GET on resource : " + uriInfo.getPath());
		return Response.ok( map.get(pnr)).header("responseHeaderName", "responseHeaderValue").build();
	}
	
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPhoneNr(@Context UriInfo uriInfo, PersonDto person) {
    	String personNr = createNewMaping(person);
        URI uri = uriInfo.getBaseUriBuilder()
            .path(PhoneNrResource.class)
            .path(personNr)
            .build();
        return Response.created(uri).build();
    }

	private String createNewMaping(PersonDto person) {
		PhoneNumber phoneNr = new PhoneNumber();
		phoneNr.setNumber(person.getPhoneNr());
		phoneNr.setCountryCode("46");
		map.put(person.getPersonNr(), phoneNr);
		return person.getPersonNr();
	}

}
