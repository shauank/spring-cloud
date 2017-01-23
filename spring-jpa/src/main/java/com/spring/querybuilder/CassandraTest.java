package com.spring.querybuilder;

public class CassandraTest {/*
	

	
	public static void main(String[] args) {

		Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
		Session session = cluster.connect("shopping");

		MappingManager mappingManager = new MappingManager(session);

		ResultSet resultSet = session.execute("select * from products");

		Result<Products> mapper = mappingManager.mapper(Products.class).map(resultSet);

		// mapper.all().stream().forEach(product ->
		// System.out.println(product.getName()));

		// System.out.println(mappingManager.mapper(Products.class).get(3));

		Where query = QueryBuilder.select().all().from("products").where(QueryBuilder.eq("id", 3));

		ResultSet result = session.execute(query);

		mapper = mappingManager.mapper(Products.class).map(result);

		// mappingManager.mapper(Products.class).getQuery(objects)

		// MappingSession mappingSession = new MappingSession("shopping",
		// session);
		//
	}
*/}
