package se.seb.jaxrs.services;

public class CustomerNotFoundException extends RuntimeException
{
   public CustomerNotFoundException(String s)
   {
      super(s);
   }
}
