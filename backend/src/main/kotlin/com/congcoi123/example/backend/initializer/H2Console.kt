package com.congcoi123.example.backend.initializer

import org.h2.tools.Server
import org.springframework.context.annotation.Profile
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
@Profile(
    value = [
        "default"
    ]
)
class H2Console {

    private lateinit var webServer: Server
    private lateinit var tcpServer: Server

    @EventListener(ContextRefreshedEvent::class)
    fun start() {
        webServer = Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start()
        tcpServer = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start()
    }

    @EventListener(ContextClosedEvent::class)
    fun stop() {
        tcpServer.stop()
        webServer.stop()
    }
}
