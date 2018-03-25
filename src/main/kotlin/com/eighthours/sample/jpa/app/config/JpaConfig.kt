package com.eighthours.sample.jpa.app.config

import org.springframework.beans.factory.FactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory


@Configuration
@EnableJpaRepositories("com.eighthours.sample.jpa.app.repository")
class JpaConfig {

    val persistenceUnitName = "sample"

    @Bean
    fun entityManagerFactory(): FactoryBean<EntityManagerFactory> {
        return LocalContainerEntityManagerFactoryBean().apply {
            persistenceUnitName = this@JpaConfig.persistenceUnitName
        }
    }

    @Bean
    fun entityManager(emf: EntityManagerFactory): EntityManager {
        return emf.createEntityManager()
    }

    @Bean
    fun transactionManager(emf: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager().apply {
            entityManagerFactory = emf
        }
    }
}
