package se.seb.jaxrs.services;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import se.seb.jaxrs.model.Customer;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/customers")
public class CustomerResource
{
   private Map<Integer, Customer> customerDB = new ConcurrentHashMap<Integer, Customer>();
   private AtomicInteger idCounter = new AtomicInteger();

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createCustomer(Customer customer)
   {
      customer.setId(idCounter.incrementAndGet());
      customerDB.put(customer.getId(), customer);
      System.out.println("Created customer " + customer.getId());
      return Response.created(URI.create("/customers/" + customer.getId())).build();

   }

   @GET
   @Path("{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Customer getCustomer(@PathParam("id") int id)
   {
      Customer customer = customerDB.get(id);
      if (customer == null)
      {
         throw new CustomerNotFoundException("Could not find customer " + id);
      }
      return customer;
   }

   @PUT
   @Path("{id}")
   @Consumes(MediaType.APPLICATION_JSON)
   public void updateCustomer(@PathParam("id") int id, Customer update)
   {
      Customer current = customerDB.get(id);
      if (current == null) throw new CustomerNotFoundException("Could not find customer " + id);

      current.setFirstName(update.getFirstName());
      current.setLastName(update.getLastName());
      current.setStreet(update.getStreet());
      current.setState(update.getState());
      current.setZip(update.getZip());
      current.setCountry(update.getCountry());
   }
}
