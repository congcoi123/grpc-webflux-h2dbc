/**
The MIT License

Copyright (c) 2021 kong <congcoi123@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
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
