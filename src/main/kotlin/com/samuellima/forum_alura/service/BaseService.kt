package com.samuellima.forum_alura.service

interface BaseService<T, U> {

    fun getById(id: Long): T

    fun create(model: T)

    fun update(id: Long, model: U) : T

    fun delete(id: Long)
}