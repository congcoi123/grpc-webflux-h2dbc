package com.congcoi123.example.backend.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.core.io.Resource

@ConstructorBinding
@ConfigurationProperties(prefix = "grpc")
data class GrpcProperty(
    val ssl: Ssl
) {

    data class Ssl(
        val serverCertificate: Resource,
        val serverKey: Resource
    )
}
