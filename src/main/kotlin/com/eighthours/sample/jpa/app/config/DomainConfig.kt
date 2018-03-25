package com.eighthours.sample.jpa.app.config

import com.eighthours.sample.jpa.domain.usecase.TaskUsecase
import com.eighthours.sample.jpa.domain.usecase.UserUsecase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DomainConfig {

    @Bean
    fun userUsecase() = UserUsecase()

    @Bean
    fun taskUsecase() = TaskUsecase()
}
