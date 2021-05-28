package com.davis.cellebrite;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
/**
 * 
 * @author Davis
 * Web url gateway
 *
 */
@ApplicationPath("/rest")
public class CellebriteApplication extends Application {

	@Override
	public Set<Object> getSingletons() {
		HashSet<Object> singletons = new HashSet<>();
		singletons.add(new DataResource());
		singletons.add(new ExceptionHandler());
		return singletons;
	}

}
