package com.matias.crudpersons.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.matias.crudpersons.model.Person;

public class PersonDaoImp implements PersonDao {


	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public Person getForId(long id) {
        Session session = getSession();

        Query<Person> qr = session.createQuery("FROM Person p WHERE p.perId = "+ id +" ORDER BY p.perNombre ASC, p.perId ASC");
        Person person = qr.getSingleResult();
        session.close();

		return person;
	}


	@Override
	public List<Person> getForName(String nombre, String identificacion) {
        Session session = getSession();

        String sendQuery = "";

        System.out.println(identificacion);

        switch (identificacion) {
        	case "nombre":
        		sendQuery = "FROM Person p WHERE LOWER(p.perNombre) LIKE '%"+ nombre.toLowerCase() +"%' ORDER BY p.perNombre ASC, p.perId ASC";
        		break;
        	default:
        		sendQuery = "FROM Person p WHERE p.perNumeroDocumento = "+ nombre +" AND p.perTipoDocumento = '"+ identificacion.toUpperCase() +"' ORDER BY p.perNombre ASC, p.perId ASC";
        		break;
        }


        Query<Person> qr = session.createQuery(sendQuery);
        List<Person> listPersons = qr.getResultList();
        session.close();

		return listPersons;
	}


	@Override
	public List<Person> getForDocType(String tipoDocumento) {
        Session session = getSession();

        Query<Person> qr = session.createQuery("FROM Person p WHERE LOWER(p.perTipoDocumento) LIKE '%"+ tipoDocumento.toLowerCase() +"%'" +" ORDER BY p.perNombre ASC, p.perId ASC");
        List<Person> listPersons = qr.getResultList();
        session.close();

		return listPersons;
	}


	@Override
	public List<Person> getAll() {
        Session session = getSession();

        Query<Person> qr = session.createQuery("FROM Person");
        List<Person> listPersons = qr.getResultList();

        session.close();

		return listPersons;
	}


	@Override
	public void remove(Person person) {
		if (person == null)
			throw new IllegalArgumentException("The Person must be not null");

    	Session session = getSession();

	    session.beginTransaction();
    	session.delete(person);
	    session.getTransaction().commit();
	    session.close();
	}


	@Override
	public void addOrUpdate(Person person) {

		if (person == null)
			throw new IllegalArgumentException("The Person must be not null");

        Session session = getSession();

        session.beginTransaction();
        session.saveOrUpdate(person);
        session.getTransaction().commit();

        session.close();
	}


	private Session getSession () {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class);
	        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	               .applySettings(configuration.getProperties());
	        sessionFactory = configuration.buildSessionFactory(builder.build());
		}

        return sessionFactory.openSession();
	}

}