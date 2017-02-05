package br.com.simpleapp.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.simpleapp.rest.PersonRestService;

@ApplicationPath("/rest/api")
public class RestActivator extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(PersonRestService.class);
		return super.getClasses();
	}
}
