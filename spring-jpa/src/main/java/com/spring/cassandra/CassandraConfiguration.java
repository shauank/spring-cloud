package com.spring.cassandra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

import com.google.common.collect.Sets;
import com.spring.cassandra.entity.Products;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration{

	@Override
	protected String getKeyspaceName() {
		return "shopping";
	}
	
	
	@Bean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {

		BasicCassandraMappingContext mappingContext = new BasicCassandraMappingContext();

		mappingContext.setBeanClassLoader(beanClassLoader);
		mappingContext.setInitialEntitySet(Sets.newHashSet(Products.class));

		return mappingContext;
	}

}

/*class MyConf extends CassandraDataAutoConfiguration{

	public MyConf(BeanFactory beanFactory, CassandraProperties properties, Cluster cluster, Environment environment) {
		super(beanFactory, properties, cluster, environment);
	}
	
	
	@Bean
	@ConditionalOnMissingBean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		BasicCassandraMappingContext context = new BasicCassandraMappingContext();
		context.setInitialEntitySet(Sets.newHashSet(Products.class));
		return context;
	}
	
}*/
