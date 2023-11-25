package com.ui.api.automation.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;



@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetails  implements Comparable<UserDetails> {
	
	com.ui.api.automation.model.Data data;
	Support support;
	String updatedAt;
	
	
	@Override
	public int compareTo(UserDetails userDetails) {
		// TODO Auto-generated method stub
		if( this.getData().compareTo(userDetails.getData()) == 0 &&
			this.getSupport().compareTo(userDetails.getSupport()) == 0	
				) {
			return 0;
		} else
			 return 1;
		//return 0;
	}
	

}
