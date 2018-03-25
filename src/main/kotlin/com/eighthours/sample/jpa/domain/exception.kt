package com.eighthours.sample.jpa.domain


class UsecaseException(message: String, cause: Throwable? = null) : Exception(message, cause)
