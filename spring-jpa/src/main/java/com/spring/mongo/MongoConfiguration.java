package com.spring.mongo;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "customer-db";
	}

	@Override
	public Mongo mongo() throws Exception {
		MongoCredential credential = MongoCredential.createCredential("rootCustomer", "customer-db",
				"root".toCharArray());

		ServerAddress address = new ServerAddress("localhost");
		MongoClient client = new MongoClient(Arrays.asList(address), Arrays.asList(credential));
		return client;
	}

}
