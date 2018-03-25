package com.eighthours.sample.jpa.domain.usecase

import com.eighthours.sample.jpa.domain.entity.User
import com.eighthours.sample.jpa.domain.repository.UserRepository
import javax.inject.Inject
import javax.transaction.Transactional


@Transactional
class UserUsecase {

    @Inject
    private lateinit var userRepository: UserRepository

    fun registerNewUser(name: String, email: String): User {
        val user = User(name, email)
        return userRepository.save(user)
    }
}
