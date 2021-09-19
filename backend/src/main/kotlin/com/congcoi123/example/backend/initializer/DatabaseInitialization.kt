package com.congcoi123.example.backend.initializer

import com.congcoi123.example.backend.repository.SkillRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component

@Component
class DatabaseInitialization {

    private val logger: Logger = LoggerFactory.getLogger(DatabaseInitialization::class.java)

    @Bean
    fun runner(skillRepository: SkillRepository, client: DatabaseClient) = ApplicationRunner {
        client.sql {
            """                
                DROP TABLE IF EXISTS `skill`;
                
                CREATE TABLE `skill` (
                  `skill_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                  `type` INT NOT NULL,
                  `name` VARCHAR(250) DEFAULT NULL,
                  `damage` INT DEFAULT NULL
                );
                
                INSERT INTO `skill` (`type`, `name`, `damage`) VALUES(3, 'Boiling Point', 10);
            """
        }
            .fetch()
            .first()
            .subscribe()

        // testing
        skillRepository.getAllSkills().subscribe {
            logger.info("Result: ${it.toString()}")
        }
    }
}
