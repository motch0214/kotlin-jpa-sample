package com.eighthours.sample.jpa.domain.dao

import javax.inject.Inject
import javax.inject.Named
import javax.persistence.EntityManager
import javax.persistence.Id


@Named
class TaskDao {

    @Inject
    private lateinit var em: EntityManager

    fun findAll(): List<TaskDto> {
        return em.createNamedQuery("TaskDao.findAll", TaskDto::class.java)
                .resultList
    }
}


data class TaskDto(

        @Id
        val id: Long,

        val name: String,

        val owner: String
)
