package com.matias.crudpersons.dao;

import java.util.List;

import com.matias.crudpersons.model.Person;

public interface PersonDao {

	/**
	 * @param Person id
	 * @return A person
	 */
	public Person getForId (long id);

	/**
	 * @param Person name
	 * @return List<Person>
	 */
	public List<Person> getForName (String nombre, String identificacion);

	/**
	 * @param value of type document
	 * @return List<Person>
	 */
	public List<Person> getForDocType (String tipoDocumento);

	/**
	 * @return A list of all persons on database
	 */
	public List<Person> getAll();

	/**
	 * @param The person that want to delete
	 * @return true if the person is correctly deleted from database
	 */
	public void remove(Person person);

	/**
	 *
	 * @return true if the person has added/updated correctly to the database
	 */
	public void addOrUpdate(Person person);
}
