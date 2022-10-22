package com.donghoonyoo.practice.kosmospring.cosmos

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("azure.cosmos")
data class CosmosProperties(
    var uri: String = "",
    var key: String = "",
    var secondaryKey: String = "",
    var database: String = "",

    var queryMetricsEnabled: Boolean = false,
    var maxDegreeOfParallelism: Int = 0,
    var maxBufferedItemCount: Int = 0,
    var responseContinuationTokenLimitInKb: Int = 0,
)
