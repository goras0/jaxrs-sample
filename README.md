# jaxrs-sample
Sample of an JAX-RS 2.0 application

Tested on Websphere Liberty.

Root resource for test, get on a default person number:
http://localhost:9080/jaxrs-sample/rest

Get a phone number by person number:
http://localhost:9080/jaxrs-sample/rest/phoneNr/197001011234

Post a new person-number mappping
http://localhost:9080/jaxrs-sample/rest/phoneNr/
{
  "personNr": "197001011234",
  "phoneNr": "123456789"
}
