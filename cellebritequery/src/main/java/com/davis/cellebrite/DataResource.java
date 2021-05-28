package com.davis.cellebrite;

import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.davis.cellebrite.datatype.request.DataRequest;
import com.davis.cellebrite.datatype.request.QueryRequest;
import com.davis.cellebrite.datatype.response.Message;
import com.davis.cellebrite.facade.DataFacade;
import com.davis.cellebrite.facade.QueryFacade;

/**
 * 
 * @author Davis
 * Proxy class
 *
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class DataResource {
	
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Message addData(DataRequest dataRequest, @Context HttpServletRequest request) throws Exception {
		DataFacade facade = new DataFacade();
		facade.addData(dataRequest);
		return new Message("PersonData created successfully");
		
	}

	@Path("/query")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public SortedMap<String, Integer> query(QueryRequest queryRequest, @Context HttpServletRequest request) throws Exception {
		QueryFacade facade = new QueryFacade();
		return facade.query(queryRequest);
		
	}
	
}
