package com.eighthours.sample.jpa.domain.repository

import com.eighthours.sample.jpa.domain.entity.Task


interface TaskRepository {

    fun findById(id: Long): Task?

    fun save(task: Task): Task
}
