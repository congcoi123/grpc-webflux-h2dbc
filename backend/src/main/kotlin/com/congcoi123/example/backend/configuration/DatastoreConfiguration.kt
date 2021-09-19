package com.congcoi123.example.backend.configuration

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableR2dbcRepositories
@EnableTransactionManagement
class DatastoreConfiguration : AbstractR2dbcConfiguration() {
    @Value("\${spring.datasource.username}")
    private val userName: String = ""

    @Value("\${spring.datasource.password}")
    private val password: String = ""

    @Value("\${spring.datasource.dbfile}")
    private val dbFile: String = ""

    @Value("\${spring.datasource.url}")
    private val url: String = ""

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return H2ConnectionFactory(
            H2ConnectionConfiguration.builder()
                .url(url)
                .file(dbFile)
                .username(userName)
                .password(password)
                .build()
        )
    }
}