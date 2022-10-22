package com.donghoonyoo.practice.kosmospring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(
    exclude = [
        DataSourceAutoConfiguration::class,
        DataSourceTransactionManagerAutoConfiguration::class,
        HibernateJpaAutoConfiguration::class,
    ]
)
class KosmospringApplication {
    companion object {
        @JvmStatic
        @SuppressWarnings("unused")
        fun main(args: Array<String>) {
            runApplication<KosmospringApplication>(*args)
        }
    }
}