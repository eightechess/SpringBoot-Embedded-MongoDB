package com.verizon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


@Document(collection = "httpparameters")
public class HttpParameters {
	@Id
	private String key;
	private String displayName;
	private String type;
	private String httpParameterName;
	private String namespace;

}
