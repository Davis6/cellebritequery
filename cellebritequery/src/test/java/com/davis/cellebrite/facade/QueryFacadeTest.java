package com.davis.cellebrite.facade;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.davis.cellebrite.datatype.request.QueryRequest;
import com.davis.cellebrite.exceptions.DataValidationException;

public class QueryFacadeTest {
	
	QueryRequest queryRequest = new QueryRequest();
	@Test
	public void testInvalidInput() {
		QueryFacade facade = new QueryFacade();
		queryRequest.setTag("123");
		runInvalidTest(facade, queryRequest);
		queryRequest.setField("test");
		runInvalidTest(facade, queryRequest);
		queryRequest.setField("name");
		queryRequest.setTag(null);
		runInvalidTest(facade, queryRequest);


	}

	private void runInvalidTest(QueryFacade facade, QueryRequest queryRequest) {
		try {
			queryRequest.setField(null);
			facade.query(queryRequest);
			System.err.println("Test Passed");
			assertTrue(false);

		} catch (DataValidationException e) {
			System.out.println("Test Passed");
			assertTrue(true);
		}
	}

}
