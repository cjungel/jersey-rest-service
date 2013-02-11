package com.cjungel.jersey_rest_service;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple person POJO.
 * 
 * @author cjungel
 * 
 */
@XmlRootElement
public class Person implements Serializable {

	private static final long serialVersionUID = -228987950154636382L;

	String name;
	String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Person))
			return false;
		Person otherPerson = (Person) other;
		return this.getName().equals(otherPerson.getName());
	}

}
