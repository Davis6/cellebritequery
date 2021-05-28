package com.davis.cellebrite.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.davis.cellebrite.dao.Person;
import com.davis.cellebrite.datatype.request.DataRequest;

/**
 * 
 * @author Davis
 * 
 * 
 *
 */
public class DataUtil {

	public static Person parseDataRequest(DataRequest dataRequest) {
		
		Person person = new Person();
		String data = dataRequest.getData();
		person.setTag(dataRequest.getTag());
		Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(data);
	    while (m.find()) {
	    	person.setEmail(m.group());
	        break;
	    }
	    
	    int nameStart = data.indexOf("dear");
	    if(nameStart > -1){
	    	nameStart = nameStart + 5;
		    int nameEnd = data.indexOf(",", nameStart);
		    if(nameEnd > -1){
		    	String name = data.substring(nameStart, nameEnd);
		    	person.setName(name);
		    }

	    }
	    
	    int locationStart = data.indexOf("at");
	    if(locationStart > -1){
	    	locationStart = locationStart + 3;
		    int locationEnd = data.indexOf(",", locationStart);
		    if(locationEnd >-1){
		    	String location = data.substring(locationStart, locationEnd);
		    	person.setLocation(location);
		    }

	    }	  
	    
	    
	    int phoneStart = data.indexOf("number is");
	    if(phoneStart > -1){
	    	phoneStart = phoneStart + 10;
		    int phoneEnd = data.indexOf(" ", phoneStart);
		    if(phoneEnd > -1){
		    	String phone = data.substring(phoneStart, phoneEnd);
		    	person.setPhone(phone);
		    }

	    }	
		return person;
	}

	public static boolean isNullOrEmtyString(String value) {
		return (value == null || value.isEmpty());
	}


}
