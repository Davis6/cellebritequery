package com.davis.cellebrite;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.davis.cellebrite.datatype.response.Message;


@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {
	@Override
	public Response toResponse(Exception e) {
		String msg = "General error";
		if (e.getMessage() != null) {
			msg = e.getMessage();
		}
		return Response.serverError().entity(new Message(msg)).build();
	}

}
