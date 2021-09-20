package com.congcoi123.example.backend.initializer

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.Order
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component

@Component
@Order(
    value = 1
)
class DatabaseInitialization {

    @Bean
    fun runnerDatabase(client: DatabaseClient) =
        ApplicationRunner {
            client.sql {
                """                
                DROP TABLE IF EXISTS `skill`;
                
                CREATE TABLE `skill` (
                  `skill_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                  `type` INT NOT NULL,
                  `name` VARCHAR(250) DEFAULT NULL,
                  `damage` INT DEFAULT NULL,
                  `effective` BOOLEAN DEFAULT 0
                );
            """
            }
                .fetch()
                .first()
                .subscribe()
        }
}
