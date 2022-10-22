package com.donghoonyoo.practice.kosmospring.cosmos

import com.azure.core.credential.AzureKeyCredential
import com.azure.cosmos.CosmosClientBuilder
import com.azure.cosmos.DirectConnectionConfig
import com.azure.cosmos.GatewayConnectionConfig
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration
import com.azure.spring.data.cosmos.config.CosmosConfig
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories
import com.donghoonyoo.practice.kosmospring.KosmospringApplication
import com.donghoonyoo.practice.kosmospring.KosmospringAutoConfiguration
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Suppress("unused")
@Configuration
@EnableCosmosRepositories(basePackageClasses = [KosmospringApplication::class])
class CosmosConfiguration(
    private val cosmosProperties: CosmosProperties,
) : AbstractCosmosConfiguration() {
    private val logger = LoggerFactory.getLogger(KosmospringAutoConfiguration::class.java)

    private var azureKeyCredential = AzureKeyCredential(cosmosProperties.key)

    override fun getDatabaseName(): String = cosmosProperties.database

    override fun cosmosConfig(): CosmosConfig =
        CosmosConfig.builder()
            .enableQueryMetrics(cosmosProperties.queryMetricsEnabled)
            .maxDegreeOfParallelism(cosmosProperties.maxDegreeOfParallelism)
            .maxBufferedItemCount(cosmosProperties.maxBufferedItemCount)
            .responseContinuationTokenLimitInKb(cosmosProperties.responseContinuationTokenLimitInKb)
            .responseDiagnosticsProcessor { logger.info("Response Diagnostics {}", it) }
            .build()


    @get:Bean
    val cosmosClientBuilder: CosmosClientBuilder
        get() = CosmosClientBuilder()
            .endpoint(cosmosProperties.uri)
            .credential(azureKeyCredential)
            .directMode(
                DirectConnectionConfig(),
                GatewayConnectionConfig(),
            )

    fun switchToSecondaryKey() {
        azureKeyCredential.update(cosmosProperties.secondaryKey)
    }
}