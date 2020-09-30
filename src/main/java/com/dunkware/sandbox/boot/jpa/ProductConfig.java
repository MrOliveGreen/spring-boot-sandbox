package com.dunkware.sandbox.boot.jpa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
 entityManagerFactoryRef = "customerEntityManagerFactory",
 transactionManagerRef = "customerTransactionManager",
 basePackages = {
  "com.dunkware.sandbox.jpa"
 }
)
public class JpaConfig {

 @Primary
 @Bean(name = "projectDataSource")
 @ConfigurationProperties(prefix = "db2.datasource")
 public DataSource customerDataSource() {
  return DataSourceBuilder.create().build();
 }

 @Primary
 @Bean(name = "projectEntityManagerFactory")
 public LocalContainerEntityManagerFactoryBean
 entityManagerFactory(
  EntityManagerFactoryBuilder builder,
  @Qualifier("db2") DataSource dataSource
 ) {
  return builder
   .dataSource(dataSource)
   .packages("com.dunkware.sandbox.boot.jpa")
   .persistenceUnit("db1")
   .build();
 }
}

 