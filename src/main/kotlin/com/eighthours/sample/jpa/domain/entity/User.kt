package com.eighthours.sample.jpa.domain.entity

import javax.persistence.*


@Entity
@Table(name = "USER",
        uniqueConstraints = [UniqueConstraint(columnNames = ["name"])])
class User() {

    @Id
    @GeneratedValue
    val id: Long? = null

    lateinit var name: String
        private set

    lateinit var email: String
        private set

    constructor(name: String, email: String) : this() {
        this.name = name
        this.email = email
    }
}
