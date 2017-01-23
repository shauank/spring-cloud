package com.spring.querybuilder;

import java.util.List;

public class QueryRequest {
	private Select select;

	public QueryRequest(Select select) {
		this.select = select;
	}

	public Select getSelect() {
		return this.select;
	}
}

class Where {

	List<String> fields;
	Limit limit;

}

class Limit {
	private String key;
	private String value;

	public Limit(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}

class Select {

	List<String> fields;

}
