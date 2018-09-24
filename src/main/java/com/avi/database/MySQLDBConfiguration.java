/*package com.avi.database;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

*//**
 * @author avinash.k
 *
 *//*
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mySqlEntityManagerFactory",
                      transactionManagerRef = "mySqlTransactionManager",
                      basePackages = {"com.avi.repository.mysql" })
public class MySQLDBConfiguration {

	private final Logger LOGGER = LoggerFactory.getLogger(MySQLDBConfiguration.class);

	@Bean(name = "mySqlDataSource")
	@ConfigurationProperties(prefix = "spring.mysql.datasource")
	public DataSource mySqlDataSource() {
		LOGGER.info("Building MYSQL DataSousrce");
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mySqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("mySqlDataSource") DataSource dataSource) {
        LOGGER.info("Loading MYSQL entities");
        return builder.dataSource(dataSource)
                      .packages("com.avi.model.mysql")
				      .persistenceUnit("MY_SQL_ADAPTOR")
                      .build();
	}

	@Bean(name = "mySqlTransactionManager")
	public PlatformTransactionManager mySqlTransactionManager(
			@Qualifier("mySqlEntityManagerFactory") EntityManagerFactory mySqlEntityManagerFactory) {
		return new JpaTransactionManager(mySqlEntityManagerFactory);
	}

}
*/