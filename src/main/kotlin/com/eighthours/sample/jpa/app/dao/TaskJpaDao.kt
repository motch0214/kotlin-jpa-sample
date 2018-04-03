package com.eighthours.sample.jpa.app.dao

import com.eighthours.sample.jpa.domain.dao.TaskDao
import com.eighthours.sample.jpa.domain.dao.TaskDto
import org.springframework.stereotype.Repository
import javax.inject.Inject
import javax.persistence.EntityManager


@Repository
class TaskJpaDao : TaskDao {

    @Inject
    private lateinit var em: EntityManager

    override fun findAll(): List<TaskDto> {
        return em.createNamedQuery("TaskDao.findAll", TaskDto::class.java)
                .resultList
    }
}
