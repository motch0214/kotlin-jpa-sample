package com.eighthours.sample.jpa.app.repository

import com.eighthours.sample.jpa.domain.entity.User
import com.eighthours.sample.jpa.domain.repository.UserRepository
import org.springframework.data.jpa.repository.JpaRepository


interface UserJpaRepository : UserRepository, JpaRepository<User, Long>
