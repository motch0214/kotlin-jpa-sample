package com.eighthours.sample.jpa.domain

import com.eighthours.sample.jpa.app.get
import com.eighthours.sample.jpa.app.initContext
import com.eighthours.sample.jpa.domain.usecase.TaskUsecase
import com.eighthours.sample.jpa.domain.usecase.UserUsecase
import org.assertj.core.api.Assertions.assertThat
import org.junit.BeforeClass
import org.junit.Test


class TaskUsecaseTest {

    companion object {

        private lateinit var userUsecase: UserUsecase

        private lateinit var taskUsecase: TaskUsecase

        @BeforeClass
        @JvmStatic
        fun setup() {
            val context = initContext()

            userUsecase = context[UserUsecase::class]
            taskUsecase = context[TaskUsecase::class]
        }
    }

    @Test
    fun test() {
        val user = userUsecase.registerNewUser("User1", "user1@email.com")

        val task = taskUsecase.createTask("Task A", user.name)

        println(task)
        assertThat(task.name).isEqualTo("Task A")

        val tasks = taskUsecase.listUpTask()
        println(tasks)
    }
}
