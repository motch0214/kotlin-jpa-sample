package com.eighthours.sample.jpa.domain

import com.eighthours.sample.jpa.app.config.AppConfig
import com.eighthours.sample.jpa.domain.usecase.TaskUsecase
import com.eighthours.sample.jpa.domain.usecase.UserUsecase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import javax.inject.Inject


@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = [AppConfig::class])
class TaskUsecaseTest {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java.enclosingClass)
    }

    @Inject
    private lateinit var userUsecase: UserUsecase

    @Inject
    private lateinit var taskUsecase: TaskUsecase

    @Test
    fun test() {
        val user = userUsecase.registerNewUser("User1", "user1@email.com")

        val task = taskUsecase.createTask("Task A", user.name)

        log.info("task = $task")
        assertThat(task.name).isEqualTo("Task A")

        val tasks = taskUsecase.listUpTask()
        log.info("tasks = $tasks")
    }
}
