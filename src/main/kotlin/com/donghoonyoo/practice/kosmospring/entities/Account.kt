package com.donghoonyoo.practice.kosmospring.entities

import com.azure.spring.data.cosmos.core.mapping.Container
import com.donghoonyoo.practice.kosmospring.utils.Id

@Container(containerName = "account")
@SuppressWarnings("unused")
data class Account(
    val email: String,
    val name: String,
) : Id()