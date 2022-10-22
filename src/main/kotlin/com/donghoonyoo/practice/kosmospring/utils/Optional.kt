package com.donghoonyoo.practice.kosmospring.utils

import java.util.*

val <T> Optional<T>.value: T?
    get() = orElse(null)