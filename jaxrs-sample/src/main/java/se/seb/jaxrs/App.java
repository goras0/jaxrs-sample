package se.seb.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import se.seb.jaxrs.services.CustomerResource;
import se.seb.jaxrs.services.PhoneNrResource;
import se.seb.jaxrs.services.RootResource;


/**
 * 
 *
 */
@ApplicationPath("rest")
public class App extends javax.ws.rs.core.Application
{

    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(RootResource.class);
        classes.add(PhoneNrResource.class);
        classes.add(CustomerResource.class);
        return classes;
    }
	
}
