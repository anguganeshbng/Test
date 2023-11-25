package com.ui.api.automation.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestNewRecord  implements Comparable<ResponseNewRecord> {

	String name;
	String job;
	
	
	@Override
	public int compareTo(ResponseNewRecord responseNewRecord) {

		// TODO Auto-generated method stub
		if(this.getName().equals(responseNewRecord.getName()) &&
		   this.getJob().equals(responseNewRecord.getJob())) {
			return 0;
		}else 
			return 1;
	}


	
	
}
