package com.davis.cellebrite.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.davis.cellebrite.datatype.request.QueryRequest;


public class DataDAOImpl implements DataDAO {
	
	private static final String EMAIL = "email";

	private static final String NAME = "name";

	private static final String LOCATION = "location";

	private static final String PHONE = "phone";

	private static DataDAOImpl instance = new DataDAOImpl();
	
	Map<String,List<Person>> tagsMap = new HashMap<>();
	
	private DataDAOImpl(){
	}
	
	public static DataDAOImpl  getInstance() {
		return instance;
	}

	@Override
	public void addData(Person person) {
		String tag = person.getTag();
		List<Person> personList;
		if(tagsMap.containsKey(tag)){
			personList = tagsMap.get(tag);
		}else{
			personList = new CopyOnWriteArrayList<>();
		}
		personList.add(person);
		tagsMap.put(tag, personList);
		
	}

	@Override
	public SortedMap<String, Integer> getQueryData(QueryRequest queryRequest) {
		SortedMap<String, Integer> sortedMap = new TreeMap<>();
		SortedMap<String, Integer> queredMap = null;
		List<Person> personList  = tagsMap.get(queryRequest.getTag());
		if(personList == null){
			return null;
		}
		switch (queryRequest.getField()) {
		case EMAIL:
			for (Person person : personList) {
				String fieldKey = person.getEmail();
				addFieldToMap(sortedMap, fieldKey);
			}
			
			break;
		case NAME:
			for (Person person : personList) {
				String fieldKey = person.getName();
				addFieldToMap(sortedMap, fieldKey);
			}
			
			break;
		case LOCATION:
			for (Person person : personList) {
				String fieldKey = person.getLocation();
				addFieldToMap(sortedMap, fieldKey);
			}
			
			break;
		case PHONE:
			for (Person person : personList) {
				String fieldKey = person.getPhone();
				addFieldToMap(sortedMap, fieldKey);
			}
			
			break;
		default:
			break;
		}
		queredMap = sortedMap.entrySet().stream()
			    .limit(5)
			    .collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
		return queredMap;
	}

	private void addFieldToMap(SortedMap<String, Integer> sortedMap, String fieldKey) {
		fieldKey = fieldKey.toLowerCase();
		if(sortedMap.containsKey(fieldKey)){
			int numOfOccurences = sortedMap.get(fieldKey);
			numOfOccurences = numOfOccurences + 1;
			sortedMap.put(fieldKey, numOfOccurences);
		}else{
			sortedMap.put(fieldKey, 1);
		}
	}

}
