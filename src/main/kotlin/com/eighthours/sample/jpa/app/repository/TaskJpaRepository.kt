package com.eighthours.sample.jpa.app.repository

import com.eighthours.sample.jpa.domain.entity.Task
import com.eighthours.sample.jpa.domain.repository.TaskRepository
import org.springframework.data.jpa.repository.JpaRepository


interface TaskJpaRepository : TaskRepository, JpaRepository<Task, Long>
