package com.samuellima.forum_alura.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {}