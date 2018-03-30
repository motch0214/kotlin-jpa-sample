package com.eighthours.sample.jpa.app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.PropertySource


@Configuration
@Import(PersistenceConfig::class, DomainConfig::class)
@PropertySource("classpath:/config/application.yml")
class AppConfig {

    @Bean
    fun appProperties(): AppProperties {
        return AppProperties()
    }
}
