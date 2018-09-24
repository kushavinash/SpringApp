package com.avi.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *  SQL Server Configurations
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "sqlServerEntityManagerFactory",
                       transactionManagerRef = "sqlServerTransactionManager",
                       basePackages = {"com.avi.repository.sqlserver" })
public class SQLServerDBConfiguration {

    private final Logger LOGGER = LoggerFactory.getLogger(SQLServerDBConfiguration.class);

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        
    	HikariConfig jdbcConfig =new HikariConfig();    	
    	return jdbcConfig;
    }

    @Primary
    @Bean(name = "sqlServerDataSource")
    public DataSource sqlServerDataSource() {
        LOGGER.info("Building SQLServer DataSource");
        return new HikariDataSource(hikariConfig());
    }

    @Primary
    @Bean(name = "sqlServerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sqlServerEntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier("sqlServerDataSource") DataSource dataSource) {
        LOGGER.info("Loading SQLServer entities");
        return entityManagerFactoryBuilder.dataSource(dataSource)
                                          .packages("com.avi.model.sqlserver")
                                          .persistenceUnit("SQL_SERVER_ADAPTOR")
                                          .build();
    }

    @Primary
    @Bean(name = "sqlServerTransactionManager")
    public PlatformTransactionManager sqlServerTransactionManager(
            @Qualifier("sqlServerEntityManagerFactory") EntityManagerFactory sqlServerEntityManagerFactory) {
        return new JpaTransactionManager(sqlServerEntityManagerFactory);
    }

}
