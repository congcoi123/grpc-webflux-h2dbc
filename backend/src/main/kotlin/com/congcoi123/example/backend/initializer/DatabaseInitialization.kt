package com.congcoi123.example.backend.initializer

import com.congcoi123.example.backend.repository.SkillRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component

@Component
class DatabaseInitialization {

    @Bean
    fun runner(skillRepository: SkillRepository, client: DatabaseClient) = ApplicationRunner {
        val initDb = client.sql {
            """
                CREATE TABLE skill (
                  skill_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                  type ENUM('SKILL_TYPE_NONE','SKILL_TYPE_UNKNOWN','SKILL_TYPE_SUMMON','SKILL_TYPE_FIRE','SKILL_TYPE_WATER','SKILL_TYPE_WIND','SKILL_TYPE_THUNDER','SKILL_TYPE_ROCK','SKILL_TYPE_WOOD') NOT NULL,
                  name VARCHAR(250) DEFAULT NULL,
                  damage INT DEFAULT NULL
                );
                
                INSERT INTO skill VALUES(NULL, 'SKILL_TYPE_FIRE', 'Boiling Point', 10);
            """
        }

        initDb // initialize the database
            .then()
            .subscribe() // execute
    }
}
