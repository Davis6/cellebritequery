package com.davis.cellebrite.facade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.davis.cellebrite.dao.DataDAO;
import com.davis.cellebrite.dao.DataDAOImpl;
import com.davis.cellebrite.dao.Person;
import com.davis.cellebrite.datatype.request.DataRequest;
import com.davis.cellebrite.exceptions.DataValidationException;
import com.davis.cellebrite.utils.DataUtil;

/**
 * 
 * @author Davis
 * Facade for parcing data and adding Person to Map
 *
 */
public class DataFacade {
	
	private DataDAO dao;
    private static final Logger log = LogManager.getLogger();

	

	public DataFacade() {
		dao = DataDAOImpl.getInstance();
	}


	public void addData(DataRequest dataRequest) throws DataValidationException {
		
		validateRequest(dataRequest);
		
		Person person = DataUtil.parseDataRequest(dataRequest);
		dao.addData(person);
		log.info("Data added sucseesfuly");
		
	}


	private void validateRequest(DataRequest dataRequest) throws DataValidationException {
		
		if(DataUtil.isNullOrEmtyString(dataRequest.getTag())){
			String errorMessage = "Tag is empty or null";
			log.error(errorMessage);
			throw new DataValidationException(errorMessage);
		}
		
		if(DataUtil.isNullOrEmtyString(dataRequest.getData())){
			String errorMessage = "Data is empty or null";
			log.error(errorMessage);
			throw new DataValidationException(errorMessage);
		}
		
	}

}
