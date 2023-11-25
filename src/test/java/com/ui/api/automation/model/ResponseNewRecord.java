package com.ui.api.automation.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseNewRecord {

	String name;
	String job;
	String id;
	String createdAt;
	
	
	
}
