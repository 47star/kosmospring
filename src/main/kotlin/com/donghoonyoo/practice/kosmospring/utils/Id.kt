package com.donghoonyoo.practice.kosmospring.utils

import com.azure.spring.data.cosmos.core.mapping.GeneratedValue
import com.azure.spring.data.cosmos.core.mapping.PartitionKey

@SuppressWarnings("unused")
abstract class Id {
    @PartitionKey
    @GeneratedValue
    lateinit var id: String
        private set
}