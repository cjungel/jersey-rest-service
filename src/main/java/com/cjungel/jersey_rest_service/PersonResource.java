package com.cjungel.jersey_rest_service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Person resource class.
 * 
 * @author cjungel
 * 
 */
@Path("person")
public class PersonResource {

	private static ArrayList<Person> everybody = new ArrayList<Person>();

	/**
	 * Retrieves list of all people.
	 * 
	 * @return List of people.
	 */
	@GET
	@Path("/")
	@Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ArrayList<Person> getAll() {

		if (everybody.size() == 0) {
			throw new WebApplicationException(404);
		} else {
			return everybody;
		}

	}

	/**
	 * Retrieve person by it's name.
	 * 
	 * @return Person identified by name.
	 */
	@GET
	@Path("/{name}")
	@Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Person getByName(@PathParam("name") String name) {

		Person person = new Person();
		person.setName(name);

		int index = everybody.indexOf(person);

		if (index < 0) {
			throw new WebApplicationException(404);
		} else {
			return everybody.get(index);
		}

	}

	/**
	 * Inserts a person in database (in-memory ArrayList really).
	 * 
	 * @param person
	 *            Person
	 * @return 201 HTTP response code if resource successfully created.
	 */
	@POST
	@Path("/post")
	@Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response createPerson(Person person) {

		synchronized (everybody) {
			everybody.add(person);
		}

		String result = "Person saved : " + person.getName();
		return Response.status(201).entity(result).build();

	}

}
