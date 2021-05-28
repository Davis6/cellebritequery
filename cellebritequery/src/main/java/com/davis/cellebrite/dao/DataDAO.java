package com.davis.cellebrite.dao;

import java.util.SortedMap;

import com.davis.cellebrite.datatype.request.QueryRequest;


public interface DataDAO {

	void addData(Person person);
	
	SortedMap<String, Integer> getQueryData(QueryRequest queryRequest);

}
