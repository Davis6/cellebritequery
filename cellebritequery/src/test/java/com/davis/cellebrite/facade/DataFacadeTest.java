package com.davis.cellebrite.facade;

import static org.junit.Assert.*;

import org.junit.Test;

import com.davis.cellebrite.datatype.request.DataRequest;
import com.davis.cellebrite.exceptions.DataValidationException;

public class DataFacadeTest {
	@Test
	public void testInvalidInput() {
		DataFacade facade = new DataFacade();
		DataRequest dataRequest = new DataRequest();

		try {
			facade.addData(dataRequest);
			System.err.println("Test Passed");

			assertTrue(false);

		} catch (DataValidationException e) {
			System.out.println("Test Passed");
			assertTrue(true);
		}

	}
}
