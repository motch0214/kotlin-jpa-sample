package com.eighthours.sample.jpa.app.config

import org.springframework.beans.factory.annotation.Value


class AppProperties {

    @Value("\${persistenceUnitName}")
    lateinit var persistenceUnitName: String
}
