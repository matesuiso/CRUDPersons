package com.matias.crudpersons;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.matias.crudpersons.dao.PersonDaoImp;
import com.matias.crudpersons.model.Person;

@Path("principal")
public class Principal {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {


    	ApplicationContext appContext = new ClassPathXmlApplicationContext("beans/Beans.xml");

    	Person pers = (Person) appContext.getBean("personBean");

    	System.out.println(pers.getPerNombre());


    	PersonDaoImp personDao = new PersonDaoImp();

    	Person aux = new Person("Rivero", new Date(), "Matias", 36133395, "DNI");
    	aux.setPerId(1);

    	personDao.addOrUpdate(aux);

    	System.out.println(personDao.getAll().isEmpty() ? "Nada" : "Varios");

        return "Got it!";
    }






    private void myMethod () {
    	try {
	    	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	               .applySettings(configuration.getProperties());

	        SessionFactory sf = configuration.buildSessionFactory(builder.build());
	        Session session = sf.openSession();

	        Query<Person> qr = session.createSQLQuery("SELECT * FROM Person");
	        List<Person> listPersons = qr.getResultList();

	        sf.close();

	        System.out.println("Traje: "+ (listPersons == null ? "Nada" : listPersons.size()));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

		//return ! listUsers.isEmpty();
    }


}
