# jaxrs-sample
Sample of an JAX-RS 2.0 application

Tested on Websphere Liberty.

## Phone Number Service
Get a phone number by person number:
* http://localhost:9080/jaxrs-sample/rest/phoneNr/197001011234

Post a new personNr<->numberNr mappping
* http://localhost:9080/jaxrs-sample/rest/phoneNr/
{
  "personNr": "197001011234",
  "phoneNr": "123456789"
}

## Customer Service
Example Client Java code
```
Customer newCustomer = new Customer();
newCustomer.setFirstName("Tony");
newCustomer.setFirstName("Tester");

// Create a new customer
Client client = ClientBuilder.newClient();
WebTarget target = client.target("http://localhost:9080/jaxrs-sample/rest/customers/");
Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(newCustomer));
URI location = response.getLocation();		
response.close();

// Get the created customer resource
Customer customer = client.target(location).request(MediaType.APPLICATION_JSON).get(Customer.class);
client.close();
```
