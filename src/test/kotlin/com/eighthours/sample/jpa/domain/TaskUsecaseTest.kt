package com.eighthours.sample.jpa.domain

import com.eighthours.sample.jpa.app.TestApplication
import com.eighthours.sample.jpa.domain.usecase.TaskUsecase
import com.eighthours.sample.jpa.domain.usecase.UserUsecase
import org.assertj.core.api.Assertions.assertThat
import org.junit.BeforeClass
import org.junit.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext


class TaskUsecaseTest {

    companion object {

        private lateinit var userUsecase: UserUsecase

        private lateinit var taskUsecase: TaskUsecase

        @BeforeClass
        @JvmStatic
        fun setup() {
            val context = AnnotationConfigApplicationContext(TestApplication::class.java)

            userUsecase = context.getBean(UserUsecase::class.java)
            taskUsecase = context.getBean(TaskUsecase::class.java)
        }
    }

    @Test
    fun test() {
        val user = userUsecase.registerNewUser("User1", "user1@email.com")

        val task = taskUsecase.createTask("Task A", user.name)

        print(task.id)
        assertThat(task.name).isEqualTo("Task A")
    }
}
