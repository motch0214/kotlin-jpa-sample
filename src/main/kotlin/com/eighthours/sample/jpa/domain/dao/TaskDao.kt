package com.eighthours.sample.jpa.domain.dao

import javax.inject.Inject
import javax.inject.Named
import javax.persistence.*


@Named
class TaskDao {

    @Inject
    private lateinit var em: EntityManager

    fun findAll(): List<TaskDto> {
        return em.createNamedQuery("TaskDto.findAll", TaskDto::class.java)
                .resultList
    }
}


@Entity
@NamedNativeQueries(
        NamedNativeQuery(name = "TaskDto.findAll",
                query = """
                    select task.id as id, task.name as name, user.name as owner
                    from TASK task
                    join USER user on user.id = task.owner_id
                """,
                resultClass = TaskDto::class)
)
class TaskDto {

    @Id
    var id: Long = 0

    lateinit var name: String

    lateinit var owner: String
}
