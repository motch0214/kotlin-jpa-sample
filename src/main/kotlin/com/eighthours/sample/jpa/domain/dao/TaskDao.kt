package com.eighthours.sample.jpa.domain.dao

import javax.persistence.Id


interface TaskDao {

    fun findAll(): List<TaskDto>
}


data class TaskDto(

        @Id
        val id: Long,

        val name: String,

        val owner: String
)
