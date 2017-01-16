package com.spring;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.entity.cassandra.Products;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJpaApplicationTests {
	
	@Autowired ApplicationContext context;

	@Test
	public void repositoriesAreAssignedToAppropriateStores() {

		Repositories repositories = new Repositories(context);
		
		
		
//		assertThat(repositories.getEntityInformationFor(Customer.class), is(instanceOf(MongoEntityInformation.class)));
		assertThat(repositories.getEntityInformationFor(Products.class), is(instanceOf(CassandraEntityInformation.class)));
	}

}
