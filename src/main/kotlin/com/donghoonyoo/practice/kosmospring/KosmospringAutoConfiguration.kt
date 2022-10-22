package com.donghoonyoo.practice.kosmospring

import com.donghoonyoo.practice.kosmospring.cosmos.CosmosProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableConfigurationProperties(value = [
    KosmospringProperties::class,
    CosmosProperties::class,
])
@ComponentScan(basePackageClasses = [KosmospringApplication::class])
@Configuration
class KosmospringAutoConfiguration
