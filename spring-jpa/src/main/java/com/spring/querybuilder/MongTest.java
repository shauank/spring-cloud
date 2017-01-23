package com.spring.querybuilder;

public class MongTest {
	
	/*public static void main(String[] args) {

		Morphia morphia = new Morphia();
		morphia.mapPackage("com.spring.entity.mongo");
		
		
		MongoCredential credential = MongoCredential.createCredential("rootCustomer", "customer-db",
				"root".toCharArray());

		ServerAddress address = new ServerAddress("localhost");
		MongoClient client = new MongoClient(Arrays.asList(address), Arrays.asList(credential));
		
		
		final Datastore datastore = morphia.createDatastore(client, "customer-db");
		datastore.ensureIndexes();
		
		
		Query<Customer> query = datastore.createQuery(Customer.class);
		query.and(query.criteria("firstName").contains("shaunak"));
		
//		query.criteria("firstName").l
		
		System.out.println(query.asList());
		
	
	}*/

}
