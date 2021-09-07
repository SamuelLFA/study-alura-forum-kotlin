package com.samuellima.forum_alura

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ForumAluraApplication

fun main(args: Array<String>) {
    runApplication<ForumAluraApplication>(*args)
}
