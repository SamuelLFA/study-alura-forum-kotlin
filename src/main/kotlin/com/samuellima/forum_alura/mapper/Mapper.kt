package com.samuellima.forum_alura.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
