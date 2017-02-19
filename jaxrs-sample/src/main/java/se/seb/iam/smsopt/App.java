package se.seb.iam.smsopt;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import se.seb.iam.smsopt.services.PhoneNrResource;
import se.seb.iam.smsopt.services.RootResource;


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
        return classes;
    }
	
}
