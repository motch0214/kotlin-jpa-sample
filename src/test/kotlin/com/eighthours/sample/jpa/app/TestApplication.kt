package com.eighthours.sample.jpa.app

import com.eighthours.sample.jpa.app.config.DomainConfig
import com.eighthours.sample.jpa.app.config.PersistenceConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import


@Configuration
@Import(TestPersistenceConfig::class, DomainConfig::class)
class TestApplication


@Configuration
class TestPersistenceConfig : PersistenceConfig() {
    override val persistenceUnitName: String get() = "sample-test"
}
