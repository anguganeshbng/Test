package com.ui.api.automation.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;



@lombok.Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Support  implements Comparable<Support> {
	
	
	String url;
	String text;
	
	
	@Override
	public int compareTo(Support support) {
		// TODO Auto-generated method stub
		if(this.getUrl().equals(support.getUrl()) &&
			this.getText().equals(support.getText()))
			return 0;
		else 
			return 1;
	}
	

}
