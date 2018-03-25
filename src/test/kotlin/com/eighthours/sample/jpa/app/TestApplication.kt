package com.eighthours.sample.jpa.app

import com.eighthours.sample.jpa.app.config.DomainConfig
import com.eighthours.sample.jpa.app.config.PersistenceConfig
import org.springframework.beans.factory.BeanFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import kotlin.reflect.KClass


@Configuration
@Import(TestPersistenceConfig::class, DomainConfig::class)
class TestApplication


@Configuration
class TestPersistenceConfig : PersistenceConfig() {
    override val persistenceUnitName: String get() = "sample-test"
}


fun initContext() = AnnotationConfigApplicationContext(TestApplication::class.java)

operator fun <T : Any> BeanFactory.get(clazz: KClass<T>): T = this.getBean(clazz.java)
