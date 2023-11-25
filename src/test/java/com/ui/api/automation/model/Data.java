package com.ui.api.automation.model;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;



@lombok.Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Data implements Comparable<Data> {
	
	int id;
	String email;
	String first_name;
	String last_name;
	String avatar;
	
	
	
	
	
	@Override
	public int compareTo(Data data) {
		// TODO Auto-generated method stub
		if(this.getId() == data.getId() &&
		   this.getEmail().equals(data.getEmail()) &&
		   this.getFirst_name().equals(data.getFirst_name()) &&
		   this.getLast_name().equals(data.getLast_name()) && 
		   this.getAvatar().equals(data.getAvatar()))
			return 0;
		else 
			return 1;
	}
	
	
	
}
