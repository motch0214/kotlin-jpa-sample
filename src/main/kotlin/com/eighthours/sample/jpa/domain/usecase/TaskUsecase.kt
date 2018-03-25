package com.eighthours.sample.jpa.domain.usecase

import com.eighthours.sample.jpa.domain.UsecaseException
import com.eighthours.sample.jpa.domain.entity.Task
import com.eighthours.sample.jpa.domain.repository.TaskRepository
import com.eighthours.sample.jpa.domain.repository.UserRepository
import javax.inject.Inject
import javax.transaction.Transactional


@Transactional
class TaskUsecase {

    @Inject
    private lateinit var taskRepository: TaskRepository

    @Inject
    private lateinit var userRepository: UserRepository

    @Throws
    fun createTask(name: String, userName: String): Task {
        val user = userRepository.findByName(userName) ?: throw UsecaseException("User ($userName) not found.")
        val task = Task(name, user)
        return taskRepository.save(task)
    }

    fun doneTask(taskId: Long) {
        val task = taskRepository.findById(taskId) ?: throw IllegalArgumentException("Task not found. id=$taskId")
        task.done()
    }
}
