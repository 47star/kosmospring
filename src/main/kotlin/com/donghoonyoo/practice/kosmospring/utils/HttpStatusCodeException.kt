package com.donghoonyoo.practice.kosmospring.utils

import org.springframework.http.HttpStatus
import org.springframework.web.client.HttpStatusCodeException

fun HttpStatusCodeException(statusCode: HttpStatus, message: String?) =
    object : HttpStatusCodeException(statusCode, message ?: statusCode.reasonPhrase) {}