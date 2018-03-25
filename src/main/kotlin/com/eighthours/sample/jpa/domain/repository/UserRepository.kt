package com.eighthours.sample.jpa.domain.repository

import com.eighthours.sample.jpa.domain.entity.User


interface UserRepository {

    fun save(user: User): User

    fun findByName(name: String): User?
}
