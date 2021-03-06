package com.fassine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fassine.entity.Banco2Details;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "banco2EntityManager", 
		transactionManagerRef = "banco2TransactionManager", 
		basePackages = "com.fassine.database2.repository"
)
public class Banco2Config {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.banco2.datasource")
	public DataSource mybanco2Datasource() {
		return DataSourceBuilder
				.create()
				.build();
	}
	
	@Bean(name = "banco2EntityManager")
	public LocalContainerEntityManagerFactoryBean banco2EntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
					.dataSource(mybanco2Datasource())
					.properties(hibernateProperties())
					.packages(Banco2Details.class)
					.persistenceUnit("banco2PU")
					.build();
	}
	
	@Bean(name = "banco2TransactionManager")
	public PlatformTransactionManager postgresTransactionManager(@Qualifier("banco2EntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	private Map<String, Object> hibernateProperties() {

		Resource resource = new ClassPathResource("hibernate.properties");
		
		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			return properties.entrySet()
					.stream()
					.collect(Collectors.toMap(
							e -> e.getKey().toString(),
							e -> e.getValue())
							);
		} catch (IOException e) {
			return new HashMap<String, Object>();
		}
	}

}
