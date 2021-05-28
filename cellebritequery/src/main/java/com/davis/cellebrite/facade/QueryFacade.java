package com.davis.cellebrite.facade;

import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.davis.cellebrite.dao.DataDAO;
import com.davis.cellebrite.dao.DataDAOImpl;
import com.davis.cellebrite.datatype.request.QueryRequest;
import com.davis.cellebrite.exceptions.DataValidationException;
import com.davis.cellebrite.utils.DataUtil;

/**
 * 
 * @author Davis
 * 
 * Facade for quering database by field
 * retrievse first 5 instance of fields requested
 *
 */
public class QueryFacade {
	
	private DataDAO dao;
    private static final Logger log = LogManager.getLogger();
    private static final List<String> fields = Arrays.asList("name","phone","email","location");

	

	public QueryFacade() {
		this.dao = DataDAOImpl.getInstance();
	}


	public SortedMap<String, Integer> query(QueryRequest queryRequest) throws DataValidationException {
		validateRequest(queryRequest);
		SortedMap<String, Integer> queryResponse = dao.getQueryData(queryRequest);
		log.info("Data query sucseesful");
		return queryResponse;
		
	}


	private void validateRequest(QueryRequest queryRequest) throws DataValidationException {
		if(DataUtil.isNullOrEmtyString(queryRequest.getTag())){
			String errorMessage = "Tag is empty or null";
			log.error(errorMessage);
			throw new DataValidationException(errorMessage);
		}
		String field = queryRequest.getField();
		if(DataUtil.isNullOrEmtyString(field)){
			String errorMessage = "Field is empty or null";
			log.error(errorMessage);
			throw new DataValidationException(errorMessage);
		}
		if(!fields.contains(field)){
			String errorMessage = "unknow field query: " + field;
			log.error(errorMessage);
			throw new DataValidationException(errorMessage);
		}
		
	}

}
