package com.eighthours.sample.jpa.app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence


@Configuration
@EnableJpaRepositories("com.eighthours.sample.jpa.app.repository")
@ComponentScan("com.eighthours.sample.jpa.app.dao")
@EnableTransactionManagement
class PersistenceConfig {

    @Bean
    fun entityManagerFactory(appProps: AppProperties): EntityManagerFactory {
        return Persistence.createEntityManagerFactory(appProps.persistenceUnitName)
    }

    @Bean
    fun transactionManager(emf: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager().apply {
            entityManagerFactory = emf
        }
    }
}
