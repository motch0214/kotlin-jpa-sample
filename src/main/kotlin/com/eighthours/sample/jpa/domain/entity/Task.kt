package com.eighthours.sample.jpa.domain.entity

import java.time.ZonedDateTime
import javax.persistence.*


@Entity
@Table(name = "TASK")
class Task() {

    @Id
    @GeneratedValue
    var id: Long? = null
        private set

    lateinit var name: String
        private set

    lateinit var status: TaskStatus
        private set

    var doneDateTime: ZonedDateTime? = null
        private set

    @ManyToOne
    lateinit var owner: User
        private set

    constructor(name: String, owner: User) : this() {
        this.name = name
        this.status = TaskStatus.UNDONE
        this.owner = owner
    }

    fun done() {
        status = TaskStatus.DONE
        doneDateTime = ZonedDateTime.now()
    }

    fun assignTo(user: User) {
        owner = user
    }
}


enum class TaskStatus {
    UNDONE, DONE
}
