package com.matias.crudpersons;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.matias.crudpersons.dao.PersonDaoImp;
import com.matias.crudpersons.model.Person;

@Path("persons")
public class crudpersons {


	@Path("findId")
	@GET
	@Produces(MediaType.APPLICATION_JSON + "; charset=ISO-8859-1")
	public Person findPerson (
			@DefaultValue("-1")
			@QueryParam("perId") long id) {

		if (id < 0)
			return null;

		try {
			return new PersonDaoImp().getForId(id);
		} catch (Exception e) {
			return null;
		}
	}


	@Path("findName")
	@GET
	@Produces(MediaType.APPLICATION_JSON + "; charset=ISO-8859-1")
	public List<Person> findPerson (
			@DefaultValue("NO NAME")
			@QueryParam("perNombre") String name,
			@DefaultValue("nombre1")
			@QueryParam("filter") String filter) {

		if (name.equals("NO NAME"))
			return null;

		try {
			return new PersonDaoImp().getForName(name, filter);
		} catch (Exception e) {
			return null;
		}
	}


}
