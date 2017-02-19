package se.seb.jaxrs.clients;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import se.seb.jaxrs.model.Customer;

public class CustomerClient {
	
	
	public static String callService(){
		StringBuilder result = new StringBuilder();
		result.append("<html>");
		result.append("<body>");
		

		Customer newCustomer = new Customer();
		newCustomer.setFirstName("Tony");
		newCustomer.setFirstName("Tester");

		// Create a new customer
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://localhost:9443/jaxrs-sample/rest/customers/");
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(newCustomer));
		URI location = response.getLocation();
		result.append("New resource created : " + location.toString());
		result.append("<p>");
		response.close();

		// Get the created customer resource
		Customer customer = client.target(location).request(MediaType.APPLICATION_JSON).get(Customer.class);
		result.append("Customer : " + customer.getFirstName() + " " + customer.getLastName());
		result.append("</body>");
		result.append("</html>");

		client.close();
		
		return result.toString();
	}
	

}
