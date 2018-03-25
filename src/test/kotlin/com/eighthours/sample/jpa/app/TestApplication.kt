package com.eighthours.sample.jpa.app

import com.eighthours.sample.jpa.app.config.DomainConfig
import com.eighthours.sample.jpa.app.config.JpaConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import


@Configuration
@Import(TestJpaConfig::class, DomainConfig::class)
class TestApplication


@Configuration
class TestJpaConfig : JpaConfig() {
    override val persistenceUnitName: String get() = "sample-test"
}
